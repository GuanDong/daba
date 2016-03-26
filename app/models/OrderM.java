package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.GenericModel;

@Entity
public class OrderM extends GenericModel {

    @Id
    public String id;

    public String no;

    public String name;

    public String city;

    @Temporal(TemporalType.TIMESTAMP)
    public Date createdDate;

    public String createdAccount;

    @OrderBy("lastUpdatedDate DESC")
    @Temporal(TemporalType.TIMESTAMP)
    public Date lastUpdatedDate;
}
