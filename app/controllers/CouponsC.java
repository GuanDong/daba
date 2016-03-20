package controllers;

import models.*;
import org.apache.commons.lang.time.DateFormatUtils;

import play.mvc.*;

import java.util.*;

public class CouponsC extends Controller {

    public static void list() {
        render();
    }

    public static void getEffectiveCoupons() {

        List<CouponM> coupons = CouponM.find("byEffectiveDateGreaterThanEquals", DateFormatUtils.format(new Date(), "MM/dd/yyyy")).fetch();
        renderJSON(coupons);
    }

}
