package controllers;

import models.CouponM;
import org.apache.commons.lang.time.DateFormatUtils;
import play.mvc.Controller;
import play.mvc.With;

import java.util.Date;
import java.util.List;

@With(Application.class)
public class CouponsC extends Controller {

    public static void list() {
        render();
    }

    public static void getEffectiveCoupons() {

        List<CouponM> coupons = CouponM.find("byEffectiveDateGreaterThanEquals", DateFormatUtils.format(new Date(), "MM/dd/yyyy")).fetch();
        renderJSON(coupons);
    }

}
