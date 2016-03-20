package controllers;

import models.Account;
import play.mvc.Controller;

import java.util.*;

public class ProductController extends Controller {

    public static void getUser(String openId) {
        Account user = Account.find("byOpenId", openId).first();
        renderJSON(user);
    }

}
