package controllers;

import me.chanjar.weixin.common.exception.WxErrorException;
import models.AccountM;
import org.apache.commons.lang.StringUtils;
import play.Logger;
import play.Play;
import play.cache.Cache;
import play.mvc.Before;
import play.mvc.Controller;

public class Application extends Controller {

    public static String BASE_URL = Play.configuration.getProperty("application.baseUrl");

    @Before(priority = 1)
    public static void processOAuth() throws WxErrorException {
        String code = params.get("code");
        String state = params.get("state");
        Logger.info("code: %s, state: %s", code, state);
        if (StringUtils.equals(state, "auth") && !StringUtils.isBlank(code)){
            String openId = WechatC.getOpenIdByCode(code);
            AccountM account = AccountM.find("byOpenId", openId).first();
            if (account != null){
                Cache.set(session.getAuthenticityToken(), new AuthenticityInfo(account.id, account.openId, account.name));
                return;
            } else {
                subscribe();
            }
        }

    }

    @Before(unless = "subscribe", priority = 2)
    public static void checkLogin(){

        String authToken = session.getAuthenticityToken();
        AuthenticityInfo authInfo = Cache.get(authToken, AuthenticityInfo.class);
        if (authInfo != null){
            return;
        }
        Logger.info("base: %s, url: %s", BASE_URL, request.url);
        redirect(WechatC.callBackOpenIdUrl(BASE_URL + request.url, "auth"));
    }

    public static void index() {
        ProductsC.list(null);
    }

    public static void subscribe() {
        renderText("请关注后订餐");
    }

    public static void login() {
        render();
    }

    public static void logout() {
        render();
    }

    public static class AuthenticityInfo {
        public String currentUserId;
        public String currentUserOpenId;
        public String currentUserName;

        public AuthenticityInfo(String id, String openId, String name){
            this.currentUserId = id;
            this.currentUserOpenId = openId;
            this.currentUserName = name;
        }
    }
}