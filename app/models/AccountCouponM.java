package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="huhu_my_coupon_info_v")
public class AccountCouponM extends GenericModel {

    @Id
    @Column(name="row_id")
    public String id;

    @Column(name="accnt_id")
    public String accountId;

    @Column(name="coupon_id")
    public String couponId;

    @Column(name="name")
    public String couponName;

    @Column(name="desc_text")
    public String couponDesc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date")
    public Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date")
    public Date endtDate;

    @Column(name="usg_flg")
    public String useFlag;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_upd")
    public Date lastUpdatedDate;
}
