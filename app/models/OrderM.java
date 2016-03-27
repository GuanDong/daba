package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

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
