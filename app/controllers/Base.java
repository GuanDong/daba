package controllers;

import me.chanjar.weixin.common.exception.WxErrorException;
import models.AccountM;
import org.apache.commons.lang.StringUtils;
import play.Play;
import play.cache.Cache;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Util;

import java.io.Serializable;

public class Base extends Controller {

    public static String BASE_URL = Play.configuration.getProperty("application.baseUrl");

    @Before(priority = 1)
    public static void processOAuth() throws WxErrorException {
        String code = params.get("code");
        String state = params.get("state");
        if (StringUtils.equals(state, "auth") && !StringUtils.isBlank(code)){
            String openId = Wechat.getOpenIdByCode(code);
            AccountM account = AccountM.find("byOpenId", openId).first();
            if (account != null){
                Cache.set(session.getAuthenticityToken(), new AuthenticityInfo(account.id, account.openId, account.name, account.headimgurl));
                return;
            } else {
                Application.subscribe();
            }
        }

    }

    @Before(unless = "subscribe", priority = 2)
    public static void checkLogin(){

        String authToken = session.getAuthenticityToken();
        AuthenticityInfo authInfo = Cache.get(authToken, AuthenticityInfo.class);
        if (authInfo != null){
            renderArgs.put("authInfo", authInfo);
            return;
        }
        redirect(Wechat.callBackOpenIdUrl(BASE_URL + request.url, "auth"));
    }

//    @Before
//    public static void checkLogin() {
//        renderArgs.put("authInfo", new AuthenticityInfo("1", "o8K-Ts8IYGgigH2HXXC-Qusu62o0", "笑尽英雄", "http://wx.qlogo.cn/mmopen/6Nhfm3wL8UDfblOic9qGYepa3rsLVrY0u4DiaJAEz6k0QpzKKW5iag2TUlb6khK2mzqYThp05llYVdJAX3C3YrLPqo3DTUFTFQj/0"));
//    }

    @Util
    public static String getAccountOpenId() {
        AuthenticityInfo authInfo = renderArgs.get("authInfo", AuthenticityInfo.class);
        if (authInfo == null) return null;
        return authInfo.openId;
    }

    public static class AuthenticityInfo implements Serializable {
        public String id;
        public String openId;
        public String name;
        public String headimgurl;

        public AuthenticityInfo(String id, String openId, String name, String headimgurl) {
            this.id = id;
            this.openId = openId;
            this.name = name;
            this.headimgurl = headimgurl;
        }
    }
}
