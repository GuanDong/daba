package controllers;

import consts.DabbawalConsts;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        Products.index(null);
    }

    public static void subscribe() {
        redirect(DabbawalConsts.ABOUT_PAGE_URL);
//        render();
    }

    public static void login() {
        render();
    }

    public static void logout() {
        render();
    }

}
