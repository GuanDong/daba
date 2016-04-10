package controllers;

import consts.DabbawalConsts;
import models.AccountCouponM;
import models.CouponM;
import org.apache.commons.lang.StringUtils;
import soap.HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub;
import soap.SoapInvoker;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public class Coupons extends Base {

    public static void index() {
        List<CouponM> coupons = CouponM.find("endDate >= ? order by sortNum", new Date()).fetch();
        List<AccountCouponM> myCoupons = AccountCouponM.find("accountId = ?", getAccountOpenId()).fetch();
        render(coupons, myCoupons);
    }

    public static void take(String couponId) throws RemoteException {
        AccountCouponM coupon = AccountCouponM.find("accountId = ? and couponId = ?", getAccountOpenId(), couponId).first();
        if (coupon != null) {
            renderJSON("");
        }

        HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub.CreatedAccountCoupon_Input input = new HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub.CreatedAccountCoupon_Input();
        input.setAccntid(getAccountOpenId());
        input.setCouponid(couponId);
        HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub.CreatedAccountCoupon_Output output = SoapInvoker.takeCoupon(input);
        if (StringUtils.equals(DabbawalConsts.RESPONSE_RESULT_SUCCESS, output.getProcStatus())) {
            renderText(DabbawalConsts.RESPONSE_RESULT_SUCCESS);
        } else {
            renderText(output.getProcMsg());
        }
    }

}
