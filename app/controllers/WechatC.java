package controllers;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import org.apache.commons.lang.StringUtils;
import play.Play;
import play.mvc.Before;
import play.mvc.Controller;
import utils.WeiXinUtils;

import java.util.Map;

public class WechatC extends Controller {

    private static WxMpConfigStorage wxMpConfigStorage;
    private static WxMpService wxMpService;
    private static WxMpMessageRouter wxMpMessageRouter;

    @Before
    public static void init() {
        if (wxMpConfigStorage != null || wxMpService != null || wxMpMessageRouter != null){
            return;
        }
        wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        ((WxMpInMemoryConfigStorage) wxMpConfigStorage).setAppId(Play.configuration.getProperty("weixin.appid")); // 设置微信公众号的appid
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
                .event("subscribe")
                .handler(new SubscrbeHandler())
                .end()
                //取消关注
                .rule()
                .async(true)
                .event("unsubscribe")
                .handler(new UnSubscrbeHandler())
                .end();

    }

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

        if ("raw".equals(encryptType)) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.body);
            WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
            renderXml(outMessage.toXml());
        }

        if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            String msgSignature = params.get("msg_signature");
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(request.body, wxMpConfigStorage, timestamp, nonce, msgSignature);
            WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
            renderXml(outMessage.toEncryptedXml(wxMpConfigStorage));
        }

        error("不可识别的加密类型");
    }

    public static void notice() {
        render();
    }

    /*
     * 微信消息处理
     */
    public static class SubscrbeHandler implements WxMpMessageHandler {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
            WxMpXmlOutTextMessage m
                    = WxMpXmlOutMessage.TEXT().content("欢迎关注").fromUser(wxMpXmlMessage.getToUserName())
                    .toUser(wxMpXmlMessage.getFromUserName()).build();
            return m;
        }
    };

    public static class UnSubscrbeHandler implements WxMpMessageHandler {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
            WxMpXmlOutTextMessage m
                    = WxMpXmlOutMessage.TEXT().content("下次再来").fromUser(wxMpXmlMessage.getToUserName())
                    .toUser(wxMpXmlMessage.getFromUserName()).build();
            return m;
        }
    };

}