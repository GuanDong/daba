package controllers;

import models.Account;

import play.*;
import play.mvc.*;

import java.util.*;

public class OrderController extends Controller {

    public static void getUser(String openId) {
        Account user = Account.find("byOpenId", openId).first();
        renderJSON(user);
    }

}
