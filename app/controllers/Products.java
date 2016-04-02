package controllers;

import beans.DistributeInfo;
import models.AccountCouponM;
import models.ProductM;
import org.apache.commons.lang.time.DateUtils;
import play.cache.Cache;
import play.db.jpa.JPA;
import play.mvc.With;

import java.util.Date;
import java.util.List;

@With(Application.class)
public class Products extends Base {

    public static void index(Date orderDay) {
        if (orderDay == null) {
            orderDay = new Date();
        }
        DateUtils.setHours(orderDay, 0);
        DateUtils.setMinutes(orderDay, 0);
        DateUtils.setSeconds(orderDay, 0);
        DateUtils.setMilliseconds(orderDay, 0);

        List<ProductM> productList = ProductM.find("startDate <= ? and endDate >= ? order by hotLevel desc", orderDay, orderDay).fetch();
        render(productList);
    }

    public static void book(String productId) {
        ProductM product = ProductM.findById(productId);
        List<AccountCouponM> couponList = AccountCouponM.find("accountId = ? and useFlag = 'Y' order by endtDate", getAccountOpenId()).fetch();

        String position = Cache.get(getAccountOpenId() + "_position", String.class);
        String sql = "select " +
                "new DistributeInfo(contactId, contactName, contectPhone, addressId, addressCity, addressBlock, addressUnit, addressDetail, latitude, longitude)" +
                " from OrderM where accountId = :accountId";
        List<DistributeInfo> distributeInfoList = null;

        if (position == null) {
            distributeInfoList = JPA.em().createQuery(sql)
                    .setParameter("accountId", getAccountOpenId())
                    .getResultList();
        } else {
            String[] longLat = position.split("-");
            sql += " order by power(longitude - :longitude, 2) + power(latitude - :latitude, 2)";
            distributeInfoList = JPA.em().createQuery(sql)
                    .setParameter("accountId", getAccountOpenId())
                    .setParameter("longitude", Double.parseDouble(longLat[0]))
                    .setParameter("latitude", Double.parseDouble(longLat[1]))
                    .getResultList();
        }
        render(product, couponList, distributeInfoList);
    }


}
