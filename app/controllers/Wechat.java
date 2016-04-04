package controllers;

import com.google.gson.Gson;
import consts.DabbawalConsts;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.common.util.crypto.WxCryptUtil;
import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.bean.*;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialNewsBatchGetResult;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpPayCallback;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import models.OrderM;
import org.apache.commons.lang.StringUtils;
import play.Logger;
import play.Play;
import play.cache.Cache;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Util;
import soap.HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub;
import soap.HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub;
import soap.SoapInvoker;
import utils.DateUtils;

import java.rmi.RemoteException;
import java.util.*;

public class Wechat extends Controller {

    private static WxMpConfigStorage wxMpConfigStorage;
    private static WxMpService wxMpService;
    private static WxMpMessageRouter wxMpMessageRouter;

    @Before
    public static void init() {
        if (wxMpConfigStorage != null || wxMpService != null || wxMpMessageRouter != null) {
            return;
        }
        wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setAppId(Play.configuration.getProperty("weixin.appid")); // 设置微信公众号的appid
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setSecret(Play.configuration.getProperty("weixin.secret")); // 设置微信公众号的app corpSecret
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setPartnerId(Play.configuration.getProperty("weixin.partnerid")); // 设置微信商家号
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setPartnerKey(Play.configuration.getProperty("weixin.partnersecret")); // 设置微信商家号
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setToken(Play.configuration.getProperty("weixin.token")); // 设置微信公众号的token
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setAesKey(Play.configuration.getProperty("weixin.encodingAESKey")); // 设置微信公众号的EncodingAESKey

        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

        wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
        wxMpMessageRouter
                //关注
                .rule()
                .async(false)
                .event(WxConsts.EVT_SUBSCRIBE)
                .handler(new SubscrbeHandler())
                .end()
                //取消关注
                .rule()
                .async(false)
                .event(WxConsts.EVT_UNSUBSCRIBE)
                .handler(new UnSubscrbeHandler())
                .end()
                //地理位置
                .rule()
                .async(false)
                .event(WxConsts.EVT_LOCATION)
                .handler(new LocationHandler())
                .end();
    }

    /*
     * 微信消息路由
     */
    public static void index() {
        String signature = params.get("signature");     // 微信加密签名
        String echostr = params.get("echostr");         // 随机字符串
        String timestamp = params.get("timestamp");     // 时间戳
        String nonce = params.get("nonce");             // 随机数

        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            // 消息签名不正确，说明不是公众平台发过来的消息
            error("非法请求");
        }
        if (StringUtils.isNotBlank(echostr)) {
            // 说明是一个仅仅用来验证的请求，回显echostr
            renderText(echostr);
        }

        String encryptType = StringUtils.isBlank(params.get("encrypt_type")) ?
                "raw" :
                params.get("encrypt_type");

        Logger.info("weixin post: %s", params.get("body"));

        if ("raw".equals(encryptType)) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(params.get("body"));
            WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
            Logger.info("return weixin: %s", outMessage == null ? "" : outMessage.toXml());
            renderXml(outMessage == null ? "" : outMessage.toXml());
        }

        if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            String msgSignature = params.get("msg_signature");
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(params.get("body"), wxMpConfigStorage, timestamp, nonce, msgSignature);
            WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
            renderXml(outMessage == null ? "" : outMessage.toEncryptedXml(wxMpConfigStorage));
        }

        error("不可识别的加密类型");
    }

    /*
     * 微信支付回调接口
     */
    public static void pay() {
        String xmlMsg = params.get("body");
        WxMpPayCallback wxMpPayCallback = wxMpService.getJSSDKCallbackData(xmlMsg);
        Logger.info("pay xml: %s", xmlMsg);
        String orderNo = wxMpPayCallback.getOut_trade_no();
        OrderM order = OrderM.find("byNo", orderNo).first();
        if (StringUtils.equals(order.status, DabbawalConsts.ORDER_STATUS_NEW)) {
            try {
                HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub.ChangeOrderstatus_Output output = SoapInvoker.changeOrderStatus(order.id, DabbawalConsts.ORDER_STATUS_PAIED);
                if (StringUtils.equals("S", output.getProcStatus())) {
                    StringBuilder response = new StringBuilder("<xml>");
                    response.append(String.format("<%s>%s</%s>", new Object[]{"return_code", "<![CDATA[SUCCESS]]>", "return_code"}));
                    response.append(String.format("<%s>%s</%s>", new Object[]{"return_msg", "<![CDATA[OK]]>", "return_msg"}));
                    response.append("</xml>");
                    renderXml(response.toString());
                } else {
                    Logger.error("订单支付信息SOAP处理失败! 结果: %s, 消息: %s", output.getProcMsg(), xmlMsg);
                    return;
                }
            } catch (RemoteException e) {
                Logger.error(e, "订单支付信息SOAP处理失败! 消息: %s", xmlMsg);
                return;
            }
        }
    }

    /*
     * 服务端推送消息
     */
    public static void sendNoticeMessage(String toUserId, String templateId, String orderId) throws WxErrorException {

//        AccountM user = AccountM.findById(toUserId);
//        OrderM order = OrderM.findById(orderId);
//
//        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
//        templateMessage.setToUser(user.openId);
//        templateMessage.setTemplateId(templateId);
//        templateMessage.setUrl("/my/order/" + orderId);
////        templateMessage.setTopColor(...);
//        templateMessage.getDatas().add(new WxMpTemplateData("name", user.name, "green"));
//        templateMessage.getDatas().add(new WxMpTemplateData("orderNo", order.no, "green"));
//
//        wxMpService.templateSend(templateMessage);
//        renderText("Ok");
    }

    /*
     * 工具函数
     */
    @Util
    public static String createSign(Map<String, String> packageParams, String signKey) {
        return WxCryptUtil.createSign(packageParams, signKey);
    }

    ;

    @Util
    public static String callBackOpenIdUrl(String url, String status) {
        return wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, status);
    }

    @Util
    public static String getOpenIdByCode(String code) throws WxErrorException {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        return wxMpOAuth2AccessToken.getOpenId();
    }

    @Util
    public static String getJsapiTicket() throws WxErrorException {
        return wxMpService.getJsapiTicket();
    }

    @Util
    public static Map<String, String> getJSSDKPayInfo(String ip, String productName, OrderM order) throws WxErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("body", productName);
        params.put("out_trade_no", order.no);
//        params.put("total_fee", "1");
        params.put("total_fee", String.valueOf(order.price*100));
        params.put("spbill_create_ip", ip);
        params.put("time_start", DateUtils.format(order.createdDate,"yyyyMMddHHmmss"));
        params.put("time_expire", DateUtils.format(DateUtils.addMinutes(order.createdDate, 30),"yyyyMMddHHmmss"));
        params.put("notify_url", "http://www.dabbawal.cn/wechat/pay");
        params.put("trade_type", "JSAPI");
        params.put("openid", order.accountId);

        Logger.info("preParams: %s", new Gson().toJson(params));
        Logger.info("prePayInfo: %s", new Gson().toJson(wxMpService.getPrepayId(params)));
        return wxMpService.getJSSDKPayInfo(params);
    }

    @Util
    public static void createMenu() throws WxErrorException {
        WxMenu wxMenu = new WxMenu();
        List<WxMenu.WxMenuButton> buttons = new ArrayList<WxMenu.WxMenuButton>();
        wxMenu.setButtons(buttons);

        WxMenu.WxMenuButton button1 = new WxMenu.WxMenuButton();
        buttons.add(button1);
        button1.setName("订餐");
        button1.setType(WxConsts.BUTTON_VIEW);
        button1.setUrl(Base.BASE_URL + "/");


        WxMenu.WxMenuButton button2 = new WxMenu.WxMenuButton();
        buttons.add(button2);
        button2.setName("我的订单");
        button2.setType(WxConsts.BUTTON_VIEW);
        button2.setUrl(Base.BASE_URL + "/my");

        WxMenu.WxMenuButton button3 = new WxMenu.WxMenuButton();
        buttons.add(button3);
        button3.setName("帮助");
        button3.setType(WxConsts.BUTTON_VIEW);
        button3.setUrl(Base.BASE_URL + "/subscribe");

        wxMpService.menuCreate(wxMenu);
    }

    /*
     * 微信消息处理
     */
    public static class SubscrbeHandler implements WxMpMessageHandler {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {

            Logger.info("user msg: %s", new Gson().toJson(wxMpXmlMessage.getContent()));
            WxMpUser user = wxMpService.userInfo(wxMpXmlMessage.getFromUserName(), "zh_CN");

            Logger.info("user: %s", new Gson().toJson(user));
            HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub.CreatedAccount_Input account = new HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub.CreatedAccount_Input();
            account.setIntegrationid(user.getOpenId());
            account.setAliasname(user.getNickname());
            account.setLoc(user.getCity());
            account.setReserve1(user.getSex());

//            if (StringUtils.equals(user.getSex(), "1")) {
//                account.setReserve1("男");
//            } else if (StringUtils.equals(user.getSex(), "2")) {
//                account.setReserve1("女");
//            }

            account.setReserve2(user.getHeadImgUrl());
            try {
                HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub.CreatedAccount_Output ouput = SoapInvoker.saveAccount(account);
                if (!StringUtils.equals(DabbawalConsts.RESPONSE_RESULT_SUCCESS, ouput.getProcStatus())) {
                    Logger.error("创建账号出错: %s", ouput.getProcMsg());
                }
            } catch (RemoteException e) {
                Logger.error(e, "创建账号出错");
            }

            WxMpMaterialNewsBatchGetResult batchNews = wxMpService.materialNewsBatchGet(0, 1);
            if (batchNews.getItemCount() == 0) {
                WxMpXmlOutTextMessage m
                        = WxMpXmlOutMessage.TEXT().content("欢迎关注").fromUser(wxMpXmlMessage.getToUserName())
                        .toUser(wxMpXmlMessage.getFromUserName()).build();

                return m;
            }

            WxMpMaterialNews.WxMpMaterialNewsArticle article =  batchNews.getItems().get(0).getContent().getArticles().get(0);
            WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
            item.setDescription(article.getDigest());
            item.setPicUrl(StringUtils.isBlank(article.getThumbUrl()) ?
                    "https://mmbiz.qlogo.cn/mmbiz/6KAHbdYYvbpdFqb8Ohc1zMzObuhlDnkIbhaJ10cj6Kw7avGSjtmIYcaWqedapwg2s2frT5SgXTxicaKSGd19qtQ/0?wx_fmt=jpeg" : article.getThumbUrl();
            item.setTitle(article.getTitle());
            item.setUrl(article.getUrl());

            Logger.info("pic url: %s", article.getThumbUrl());

            WxMpXmlOutNewsMessage m = WxMpXmlOutMessage.NEWS()
                    .fromUser(wxMpXmlMessage.getToUserName())
                    .toUser(wxMpXmlMessage.getFromUserName())
                    .addArticle(item)
                    .build();
            Logger.error(m.toString());
            return m;
        }
    }

    public static class UnSubscrbeHandler implements WxMpMessageHandler {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
            WxMpXmlOutTextMessage m
                    = WxMpXmlOutMessage.TEXT().content("下次再来").fromUser(wxMpXmlMessage.getToUserName())
                    .toUser(wxMpXmlMessage.getFromUserName()).build();
            return m;
        }
    }

    public static class LocationHandler implements WxMpMessageHandler {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
            String openId = wxMpXmlMessage.getFromUserName();
            double lat = wxMpXmlMessage.getLatitude();
            double lon = wxMpXmlMessage.getLongitude();
            Cache.set(openId + "_location", Double.toString(lat) + "-" + Double.toString(lon), "1d");

            return null;
        }

    }

}
