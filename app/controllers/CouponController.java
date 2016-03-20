package controllers;

import models.Account;
import models.Coupon;
import org.apache.commons.lang.time.DateFormatUtils;
import play.libs.Time;
import play.mvc.*;

import java.util.*;

public class CouponController extends Controller {

    public static void getEffectiveCoupons() {

        List<Coupon> coupons = Coupon.find("byEffectiveDateGreaterThanEquals", DateFormatUtils.format(new Date(), "MM/dd/yyyy")).fetch();
        renderJSON(coupons);
    }

}
