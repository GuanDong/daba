package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "huhu_price_list_info_v")
public class ProductM extends GenericModel {

    @Id
    @Column(name = "row_id")
    public String id;

    @Column(name = "pri_lst_id")
    public String priceId;

    @Column(name = "prod_id")
    public String productId;

    @Column(name = "name")
    public String productName;

    @Column(name = "part_num")
    public String productNo;

    @Column(name = "dest_text")
    public String productDesc;

    @Column(name = "product_level")
    public Integer laLevel;

    @Column(name = "prod_hod")
    public Integer hotLevel;

    @Column(name = "prod_eva")
    public Integer evaLevel;

    @Column(name = "std_pri_unit")
    public Integer stdPrice;

    @Column(name = "promo_pri")
    public Integer promoPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "eff_start_dt")
    public Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "eff_end_dt")
    public Date endDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_upd")
    public Date lastUpdatedDate;
}
