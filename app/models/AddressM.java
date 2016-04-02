package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "huhu_acc_addr_info_v")
public class AddressM extends GenericModel {

    @Id
    @Column(name = "row_id")
    public String id;

    @Column(name = "accnt_id")
    public String accountId;

    @Column(name = "contact_id")
    public String contactId;

    @Column(name = "state")
    public String state;

    @Column(name = "city")
    public String city;

    @Column(name = "block")
    public String block;

    @Column(name = "unit")
    public String unit;

    @Column(name = "latitude")
    public Double latitude;

    @Column(name = "longitude")
    public Double longitude;

    @Column(name = "main_flg")
    public String mainFlag;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_upd")
    public Date lastUpdatedDate;
}
