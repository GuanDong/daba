package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="huhu_order_item_info_v")
public class OrderItemM extends GenericModel {

    @Id
    @Column(name="row_id")
    public String id;

    @Column(name="order_id")
    public String orderId;

    @Column(name="prod_id")
    public String productId;

    @Column(name="prod_cd")
    public String productType;

    @Column(name="name")
    public String productName;

    @Column(name="net_pri")
    public Float price;

    @Column(name="expctd_dlvry_dt")
    public String orderDate;

    @Column(name="status_cd")
    public String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_upd")
    public Date lastUpdatedDate;
}
