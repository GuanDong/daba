package controllers;

import beans.DistributeInfo;
import models.AccountCouponM;
import models.ProductM;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import play.Logger;
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

        String location = Cache.get(getAccountOpenId() + "_location", String.class);

        Logger.info("openId: %s, location: %s", getAccountOpenId(), location);

        String sql = "select " +
                "new beans.DistributeInfo(contactName, contectPhone, addressCity, addressBlock, addressUnit, addressDetail, latitude, longitude)" +
                " from OrderM where accountId = :accountId";
        List<DistributeInfo> distributeInfoList = null;

        if (StringUtils.isBlank(location)) {
            sql = sql +  " order by createdDate desc";
            Logger.info("sql: %s", sql);
            distributeInfoList = JPA.em().createQuery(sql)
                    .setParameter("accountId", getAccountOpenId())
                    .getResultList();
        } else {
            String[] longLat = location.split("-");
            sql = sql + " order by power(longitude - :longitude, 2) + power(latitude - :latitude, 2), createdDate desc ";
            Logger.info("sql: %s", sql);
            distributeInfoList = JPA.em().createQuery(sql)
                    .setParameter("accountId", getAccountOpenId())
                    .setParameter("longitude", Double.parseDouble(longLat[0]))
                    .setParameter("latitude", Double.parseDouble(longLat[1]))
                    .getResultList();
        }
        render(product, couponList, distributeInfoList);
    }


}
