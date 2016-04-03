package controllers;

import com.google.gson.Gson;
import models.AccountCouponM;
import models.OrderItemM;
import models.OrderM;
import play.Logger;
import play.db.jpa.GenericModel;
import play.db.jpa.JPA;

import javax.persistence.Query;
import java.util.List;

//@With(Application.class)
public class My extends Base {

    public static void index() {
//        List<OrderM> orderList = OrderM.find("accountId = ? order by createdDate", getAccountOpenId()).fetch();
//        List<OrderItemM> orderItemList = OrderItemM.find("accountId = ? order by orderId").fetch();
        List<AccountCouponM> couponList = AccountCouponM.find("accountId = ? and useFlag = 'N' order by endtDate", getAccountOpenId()).fetch();
        Query query = JPA.em().createQuery("select o as order, " +
                "(select i from OrderItemM i where i.orderId=o.orderId and i.productType='产品') as product,  " +
                "(select i from OrderItemM i where i.orderId=o.orderId and i.productType='促销') as coupon " +
                "from OrderM o where accountId = ? order by createdDate");

        query.setParameter(1, getAccountOpenId());
        List orderList = query.getResultList();
        Logger.info("orderImtes: %s", new Gson().toJson(orderList));
        render(orderList, couponList);
    }


}
