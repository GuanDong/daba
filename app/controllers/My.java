package controllers;

import models.AccountCouponM;
import models.OrderM;

import java.util.List;

//@With(Application.class)
public class My extends Base {

    public static void index() {
        List<OrderM> orderList = OrderM.find("accountId = ? order by createdDate", getAccountOpenId()).fetch();
        List<AccountCouponM> couponList = AccountCouponM.find("accountId = ? and useFlag = 'N' order by endtDate", getAccountOpenId()).fetch();
        render(orderList, couponList);
    }


}
