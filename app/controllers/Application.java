package controllers;

public class Application extends Base {

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
