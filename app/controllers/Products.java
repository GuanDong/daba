package controllers;

import consts.DabbawalConsts;
import models.AccountCouponM;
import models.CouponM;
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

        List<ProductM> productList = ProductM.find("startDate <= ? and endDate >= ? order by sortNum", orderDay, orderDay).fetch();

        Integer productCount = Cache.get("dabbawal_product_count", Integer.class);
        if (productCount == null){
            productCount = 100;
        }

        render(productList,productCount);
    }

    public static void book(String productId) {
        ProductM product = ProductM.findById(productId);
        List<CouponM> couponList = CouponM.find("id in (select couponId from AccountCouponM where accountId = ? and (useFlag is null or useFlag != ?)) order by endDate", getAccountOpenId(), DabbawalConsts.COUPON_USE_FLAG_YES).fetch();

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
