package controllers;

import play.mvc.*;

import java.util.*;

import models.*;

public class UserController extends Controller {

    public static void getUser(String openId) {
        Account user = Account.find("byOpenId", openId).first();
        renderJSON(user);
    }

}
