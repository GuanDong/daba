package controllers;

import org.apache.commons.lang.StringUtils;
import play.mvc.Before;
import play.mvc.Controller;

public class LoginC extends Controller {

    @Before
    public static void checkLogin(){
        String openId = params.get("openId");
        String whoami = session.get("whoami");

        if (!StringUtils.isBlank(whoami)){
            return;
        }

        if (!StringUtils.isBlank(whoami)){
            return;
        }

        if (request.method.equalsIgnoreCase("GET")){

        }
    }

    public static void index() {
        ProductsC.list(null);
    }

    public static void subcribe() {
        redirect("/public/subscribe.html");
    }

    public static void login() {
        render();
    }

    public static void logout() {
        render();
    }

}