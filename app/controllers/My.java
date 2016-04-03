package controllers;

import consts.DabbawalConsts;
import models.AccountCouponM;
import play.db.jpa.JPA;

import javax.persistence.Query;
import java.util.List;

//@With(Application.class)
public class My extends Base {

    public static void index() {
//        List<OrderM> orderList = OrderM.find("accountId = ? order by createdDate", getAccountOpenId()).fetch();
//        List<OrderItemM> orderItemList = OrderItemM.find("accountId = ? order by orderId").fetch();
        List<AccountCouponM> couponList = AccountCouponM.find("accountId = ? and useFlag = ? order by endtDate", getAccountOpenId(), DabbawalConsts.COUPON_USE_FLAG_NO).fetch();
        Query query = JPA.em().createQuery("select o as order, " +
                "(select i from OrderItemM i where i.orderId=o.id and i.productType=?) as product,  " +
                "(select i from OrderItemM i where i.orderId=o.id and i.productType=?) as coupon " +
                "from OrderM o where o.accountId = ? order by o.createdDate desc");

        query.setParameter(1, DabbawalConsts.PRODUCT_TYPE_PROD);
        query.setParameter(2, DabbawalConsts.PRODUCT_TYPE_COUPON);
        query.setParameter(3, getAccountOpenId());
        List orderList = query.getResultList();
//        Logger.info("orderImtes: %s", new Gson().toJson(orderList));
        render(orderList, couponList);
    }


}
