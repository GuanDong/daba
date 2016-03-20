package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="huhu_prod_list_v")
public class ProductPrice extends GenericModel {

    @Id
    @Column(name="row_id")
    public String id;

    @Column(name="pri_lst_id")
    public String priceId;

    @Column(name="prod_id")
    public String productId;

    @Column(name="std_pri_unit")
    public Float stdPrice;

    @Column(name="promo_pri")
    public Float promoPri;

    @Temporal(TemporalType.DATE)
    @Column(name="eff_start_dt")
    public Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="eff_end_dt")
    public Date endDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_upd")
    public Date lastUpdatedDate;
}
