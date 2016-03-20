package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="huhu_coupon_info_v")
public class CouponM extends GenericModel {

    @Id
    @Column(name="row_id")
    public String id;

    @Column(name="name")
    public String name;

    @Column(name="desc_text")
    public String desc;

    @Column(name="effective_date")
    public String effectiveDate;

    @Column(name="src_flg")
    public String srcFlag;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_upd")
    public Date lastUpdatedDate;
}
