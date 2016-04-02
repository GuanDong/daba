package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "huhu_account_info_v")
public class AccountM extends GenericModel {

    @Id
    @Column(name = "row_id")
    public String id;

    @Column(name = "integration_id")
    public String openId;

    @Column(name = "alias_name")
    public String name;
//
//    @Column(name="sex")
//    public String sex;
//
//    @Column(name="headimgurl")
//    public String headimgurl;

    @Column(name = "city")
    public String city;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_upd")
    public Date lastUpdatedDate;
}
