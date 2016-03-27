package controllers;

import org.apache.commons.lang.time.DateUtils;
import play.db.jpa.JPA;
import play.mvc.Controller;
import play.mvc.With;

import java.io.File;
import java.util.Date;
import java.util.List;

@With(Application.class)
public class ProductsC extends Controller {

    public static void list(Date orderDay) {
        if (orderDay == null){
            orderDay = new Date();
        }
        DateUtils.setHours(orderDay, 0);
        DateUtils.setMinutes(orderDay, 0);
        DateUtils.setSeconds(orderDay, 0);
        DateUtils.setMilliseconds(orderDay, 0);

        String sql = "select new beans.ProductInfo(p.id, p.name, p.desc, p.laLevel, p.hotLevel, p.evaLevel, pp.stdPrice) from ProductM p, ProductPriceM pp where pp.productId=p.id and pp.startDate <= :orderDay and pp.endDate>=:orderDay order by p.hotLevel desc";
        List productList = JPA.em().createQuery(sql).setParameter("orderDay", orderDay).getResultList();
        render(productList);
    }

    public static void detail(String id) {
       render();
    }

    public static void viewAvatar(String id){
        renderBinary(new File(""));
    }

}
