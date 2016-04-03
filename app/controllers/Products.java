package controllers;

import models.AccountCouponM;
import models.OrderM;
import models.ProductM;
import org.apache.commons.lang.StringUtils;
import play.Logger;
import play.cache.Cache;
import play.mvc.With;
import utils.DateUtils;

import java.util.Date;
import java.util.List;

@With(Application.class)
public class Products extends Base {

    public static void index(Date orderDay) {
        if (orderDay == null) {
            orderDay = new Date();
        }
        orderDay = DateUtils.toFirstSecond(orderDay);

        List<ProductM> productList = ProductM.find("startDate <= ? and endDate >= ? order by hotLevel desc", orderDay, orderDay).fetch();
        render(productList);
    }

    public static void book(String productId) {
        ProductM product = ProductM.findById(productId);
        List<AccountCouponM> couponList = AccountCouponM.find("accountId = ? and useFlag = 'N' order by endtDate", getAccountOpenId()).fetch();

        String location = Cache.get(getAccountOpenId() + "_location", String.class);

        Logger.info("openId: %s, location: %s", getAccountOpenId(), location);

        OrderM lastOrder = null;

        if (StringUtils.isBlank(location)) {
            lastOrder = OrderM.find("accountId = ? order by createdDate desc", getAccountOpenId()).first();
        } else {
            String[] longLat = location.split("-");

            lastOrder = OrderM.find("accountId = ? order by " +
//                    "(6371 * acos( " +
//                        "cos( radians(?) ) * cos( radians(latitude) ) * " +
//                        "cos( radians(longitude) - radians(-?) ) + " +
//                        "sin( radians(?) ) * sin( radians(latitude) )" +
//                    ")), createdDate desc",
                    "(power(longitude - ?, 2) + power(latitude - ?, 2)), createdDate desc",
                    getAccountOpenId(), Double.parseDouble(longLat[0]), Double.parseDouble(longLat[1])).first();
        }
        render(product, couponList, lastOrder);
    }


}
