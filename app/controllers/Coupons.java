package controllers;

import models.AccountCouponM;
import models.CouponM;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.List;

public class Coupons extends Base {

    public static void index() {
        List<CouponM> coupons = CouponM.find("endDate >= ? order by endDate", new Date()).fetch();
        List<AccountCouponM> myCoupons = AccountCouponM.find("accountId = ?", getAccountOpenId()).fetch();
        render(coupons, myCoupons);
    }

    public static void take(String couponId) {
        AccountCouponM coupon = AccountCouponM.find("accountId = ? and couponId = ?", getAccountOpenId(), couponId).first();
        if (coupon != null) {
            renderJSON("");
        }
        AccountCouponM accountCouponM = new AccountCouponM();
        accountCouponM.accountId = getAccountOpenId();
        accountCouponM.couponId = couponId;
        accountCouponM.save();
        renderJSON(accountCouponM.id);
    }

}
