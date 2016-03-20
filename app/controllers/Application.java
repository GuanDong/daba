package controllers;

import play.mvc.*;

public class Application extends Controller {

    public static void index() {
        render();
        ProductsC.list(null);
    }

    public static void login() {
        render();
    }

    public static void logout() {
        render();
    }

    public static void follow() {
        render();
    }

    public static void unfollow() {
        render();
    }

    public static void notice() {
        render();
    }

}