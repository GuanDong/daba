package controllers;

import com.google.gson.Gson;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.common.util.crypto.WxCryptUtil;
import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.bean.*;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpPayCallback;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import models.AccountM;
import models.OrderM;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import play.Logger;
import play.Play;
import play.cache.Cache;
import play.mvc.Before;
import play.mvc.Util;
import soap.HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub;
import soap.SoapInvoker;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wechat extends Base {

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
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setPartnerId(Play.configuration.getProperty("weixin.1314565201")); // 设置微信商家号
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setSecret(Play.configuration.getProperty("weixin.secret")); // 设置微信公众号的app corpSecret
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setToken(Play.configuration.getProperty("weixin.token")); // 设置微信公众号的token
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setAesKey(Play.configuration.getProperty("weixin.encodingAESKey")); // 设置微信公众号的EncodingAESKey

        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

        WxMpMessageHandler handler = new WxMpMessageHandler() {
            @Override
            public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                WxMpXmlOutTextMessage m
                        = WxMpXmlOutMessage.TEXT().content("测试消息").fromUser(wxMpXmlMessage.getToUserName())
                        .toUser(wxMpXmlMessage.getFromUserName()).build();
                return m;
            }
        };

        wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
        wxMpMessageRouter
                //测试
                .rule()
                .async(false)
                .content("哈哈") // 拦截内容为“哈哈”的消息
                .handler(handler)
                .end()
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
//                //支付
//                .rule()
//                .async(false)
//                .matcher(new PayMessageMatcher())
//                .handler(new PaySuccessHandler())
//                .end();

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
     * 微信消息路由
     */
    public static void pay() {

        WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(params.get("body"));
        String xmlMsg = inMessage.getContent();
        WxMpPayCallback wxMpPayCallback = wxMpService.getJSSDKCallbackData(xmlMsg);

        String orderNo = wxMpPayCallback.getOut_trade_no();
        OrderM order = OrderM.find("byNo", orderNo).first();
        if (StringUtils.equals(order.status, "已下单")) {
            try {
                SoapInvoker.changeOrderStatus(orderNo, "已支付");
            } catch (RemoteException e) {
                Logger.error(e, "订单支付信息处理失败: %s", xmlMsg);
            }
        }

        StringBuilder response = new StringBuilder("<xml>");
        response.append(String.format("<%s>%s</%s>", new Object[]{"return_code", "<![CDATA[SUCCESS]]>", "return_code"}));
        response.append(String.format("<%s>%s</%s>", new Object[]{"return_msg", "<![CDATA[OK]]>", "return_msg"}));
        response.append("</xml>");
        WxMpXmlOutTextMessage outMessage
                = WxMpXmlOutMessage.TEXT().content(response.toString()).build();
        renderXml(outMessage == null ? "" : outMessage.toXml());
    }

    /*
     * 接收支付结果消息
     */
    public static void receivePayMessage(String toUserId, String templateId, String orderId) throws WxErrorException {

        AccountM user = AccountM.findById(toUserId);
        OrderM order = OrderM.findById(orderId);

        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setToUser(user.openId);
        templateMessage.setTemplateId(templateId);
        templateMessage.setUrl("/my/order/" + orderId);
//        templateMessage.setTopColor(...);
        templateMessage.getDatas().add(new WxMpTemplateData("name", user.name, "green"));
        templateMessage.getDatas().add(new WxMpTemplateData("orderNo", order.no, "green"));

        wxMpService.templateSend(templateMessage);
        renderText("Ok");
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
    public static Map<String, String> getJSSDKPayInfo(String ip, OrderM order) throws WxErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("body", "健康午餐");
        params.put("out_trade_no", "1-500846");
        params.put("total_fee", "0.01");
        params.put("spbill_create_ip", ip);
        params.put("time_start", "20160402185859");
        params.put("time_expire", "201604022305859");
        params.put("notify_url", "http://www.dabbawal.cn/wechat/pay");
        params.put("trade_type", "JSAPI");
        params.put("openid", "o8K-Ts8IYGgigH2HXXC-Qusu62o0");

        Logger.info("prePayInfo: %s", new Gson().toJson(wxMpService.getPrepayId(params));
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
        button1.setUrl(Application.BASE_URL + "/");


        WxMenu.WxMenuButton button2 = new WxMenu.WxMenuButton();
        buttons.add(button2);
        button2.setName("我的订单");
        button2.setType(WxConsts.BUTTON_VIEW);
        button2.setUrl(Application.BASE_URL + "/my/orders");

        WxMenu.WxMenuButton button3 = new WxMenu.WxMenuButton();
        buttons.add(button3);
        button3.setName("评价");
        button3.setType(WxConsts.BUTTON_VIEW);
        button3.setUrl(Application.BASE_URL + "/my/comments");

//        WxMenu.WxMenuButton button3 = new WxMenu.WxMenuButton();
//        buttons.add(button3);
//        button3.setName("评价");
//        List<WxMenu.WxMenuButton> subButtons = new ArrayList<WxMenu.WxMenuButton>();
//        button3.setSubButtons(subButtons);
//
//        WxMenu.WxMenuButton button4 = new WxMenu.WxMenuButton();
//        subButtons.add(button4);
//        button4.setName("点赞");
//        button4.setType(WxConsts.BUTTON_VIEW);
//        button4.setUrl(callBackOpenIdUrl("/my/comments", "good"));
//
//        WxMenu.WxMenuButton button5 = new WxMenu.WxMenuButton();
//        subButtons.add(button5);
//        button5.setName("吐槽");
//        button5.setType(WxConsts.BUTTON_VIEW);
//        button5.setUrl(callBackOpenIdUrl("/my/comments", "bad"));

        wxMpService.menuCreate(wxMenu);
    }

    /*
     * 微信消息处理
     */
    public static class SubscrbeHandler implements WxMpMessageHandler {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {

            Logger.info("subscribe event");
            WxMpUser user = wxMpService.userInfo(wxMpXmlMessage.getFromUserName(), "zh_CN");

            HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub.CreatedAccount_Input account = new HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub.CreatedAccount_Input();
            account.setIntegrationid(user.getOpenId());
            account.setAliasname(user.getNickname());
            account.setLoc(user.getCity());

            if (StringUtils.equals(user.getSex(), "1")) {
                account.setReserve1("男");
            } else if (StringUtils.equals(user.getSex(), "2")) {
                account.setReserve1("女");
            }
            account.setReserve2(user.getHeadImgUrl());

            Logger.info("subscribe user: %s", new Gson().toJson(account));

            try {
                SoapInvoker.saveAccount(account);
            } catch (RemoteException e) {
                e.printStackTrace();
                Logger.info(e, "创建账号出错");
                ;
            }

            WxMpXmlOutTextMessage m
                    = WxMpXmlOutMessage.TEXT().content("欢迎关注").fromUser(wxMpXmlMessage.getToUserName())
                    .toUser(wxMpXmlMessage.getFromUserName()).build();

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
            Cache.set(openId + "_location", Double.toString(lat) + "-" + Double.toString(lon));

            return null;
        }

    }

    public static class PaySuccessHandler implements WxMpMessageHandler {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
            String xmlMsg = wxMpXmlMessage.getContent();
            WxMpPayCallback wxMpPayCallback = wxMpService.getJSSDKCallbackData(xmlMsg);

            String orderNo = wxMpPayCallback.getOut_trade_no();
            OrderM order = OrderM.find("byNo", orderNo).first();
            if (StringUtils.equals(order.status, "已下单")) {
                try {
                    SoapInvoker.changeOrderStatus(orderNo, "已支付");
                } catch (RemoteException e) {
                    Logger.error(e, "订单支付信息处理失败: %s", xmlMsg);
                }
            }

            StringBuilder response = new StringBuilder("<xml>");
            response.append(String.format("<%s>%s</%s>", new Object[]{"return_code", "<![CDATA[SUCCESS]]>", "return_code"}));
            response.append(String.format("<%s>%s</%s>", new Object[]{"return_msg", "<![CDATA[OK]]>", "return_msg"}));
            response.append("</xml>");
            WxMpXmlOutTextMessage m
                    = WxMpXmlOutMessage.TEXT().content(response.toString()).build();

            return m;
        }

    }

    public static class PayMessageMatcher implements WxMpMessageMatcher {

        @Override
        public boolean match(WxMpXmlMessage wxMpXmlMessage) {
            String xmlMsg = wxMpXmlMessage.getContent();
            WxMpPayCallback wxMpPayCallback = wxMpService.getJSSDKCallbackData(xmlMsg);
            Map payCallbackMap = new HashMap();
            try {
                payCallbackMap = BeanUtils.describe(wxMpPayCallback);
            } catch (Exception e) {
            }
            if (wxMpService.checkJSSDKCallbackDataSignature(payCallbackMap, wxMpPayCallback.getSign())) {

                if (!(StringUtils.equals(wxMpPayCallback.getResult_code(), "SUCCESS")
                        || StringUtils.isBlank(wxMpPayCallback.getTransaction_id())
                        || StringUtils.isBlank(wxMpPayCallback.getOut_trade_no())
                        || StringUtils.equals(wxMpPayCallback.getAppid(), wxMpConfigStorage.getAppId()))) {
                    return true;

                }
            }
            return false;
        }
    }

}
