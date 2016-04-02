package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "huhu_order_head_info_v")
public class OrderM extends GenericModel {

    @Id
    @Column(name = "row_id")
    public String id;

    @Column(name = "order_num")
    public String no;

    @Column(name = "accnt_id")
    public String accountId;

    @Column(name = "accnt_server_id")
    public String accountRowId;

    @Column(name = "status_cd")
    public String status;

    @Column(name = "order_amt")
    public Float price;

    @Column(name = "desc_text")
    public String notes;

    @Column(name = "name")
    public String contactName;

    @Column(name = "phone_num")
    public String contactPhone;

    @Column(name = "state")
    public String addressProvince;

    @Column(name = "city")
    public String addressCity;

    @Column(name = "block")
    public String addressBlock;

    @Column(name = "unit")
    public String addressUnit;

    @Column(name = "addr")
    public String addressDetail;

    @Column(name = "latitude")
    public Double latitude;

    @Column(name = "longitude")
    public Double longitude;

    @Column(name = "addr_name")
    public String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_upd")
    public Date lastUpdatedDate;
}
