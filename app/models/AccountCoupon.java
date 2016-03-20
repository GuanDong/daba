package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="huhu_my_coupon_info_v")
public class AccountCoupon extends GenericModel {

    @Id
    @Column(name="row_id")
    public String id;

    @Column(name="accnt_id")
    public String accountId;

    @Column(name="coupon_id")
    public String couponId;

    @Column(name="usg_flg")
    public String useFlag;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_upd")
    public Date lastUpdatedDate;
}
