package controllers;

import models.AccountM;
import org.apache.commons.lang.StringUtils;
import play.Play;
import play.cache.Cache;
import play.mvc.*;

public class Application extends Controller {

    public static String BASE_URL = Play.configuration.getProperty("application.baseUrl");

    @Before(unless = "subcribe")
    public static void checkLogin(){

        String authToken = session.getAuthenticityToken();
        AuthenticityInfo authInfo = Cache.get(authToken, AuthenticityInfo.class);
        if (authInfo != null){
            return;
        }

        String openId = params.get("openId");
        if (!StringUtils.isBlank(openId)){
            AccountM account = AccountM.find("byOpenId", openId).first();
            if (account != null){
                Cache.set(authToken, new AuthenticityInfo(account.id, account.openId, account.name));
                return;
            } else {
                subcribe();
            }
        }

        redirect(WechatC.callBackOpenIdUrl(Application.BASE_URL + request.url, null));
    }

    public static void index() {
        ProductsC.list(null);
    }

    public static void subcribe() {
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