package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="huhu_order_head_info_v")
public class OrderM extends GenericModel {

    @Id
    @Column(name="row_id")
    public String id;

    @Column(name="order_num")
    public String no;

    @Column(name="accnt_id")
    public String accountId;

    @Column(name="status_cd")
    public String status;

    @Column(name="order_amt")
    public Float price;

    @Column(name="desc_text")
    public String desc;

    @Column(name="name")
    public String contactName;

    @Column(name="phone_num")
    public String contactPhone;

    @Column(name="addr_name")
    public String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_upd")
    public Date lastUpdatedDate;
}
