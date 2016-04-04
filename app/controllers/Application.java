package controllers;

import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        Products.index(null);
    }

    public static void subscribe() {
        render();
    }

    public static void login() {
        render();
    }

    public static void logout() {
        render();
    }

}
