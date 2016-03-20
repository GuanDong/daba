package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.GenericModel;

@Entity
@Table(name="huhu_account_info_v")
public class Account extends GenericModel {

    @Id
    @Column(name="row_id")
    public String id;

    @Column(name="integration_id")
    public String openId;

    @Column(name="alias_name")
    public String name;

    @Column(name="city")
    public String city;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_upd")
    public Date lastUpdatedDate;
}
