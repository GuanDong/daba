package controllers;

import org.apache.commons.lang.StringUtils;
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

}