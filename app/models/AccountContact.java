package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="huhu_contact_info_v")
public class AccountContact extends GenericModel {

    @Id
    @Column(name="row_id")
    public String id;

    @Column(name="acc_id")
    public String accountId;

    @Column(name="last_name")
    public String name;

    @Column(name="cell_ph_num")
    public String tel;

    @Column(name="main_flag")
    public String mainFlag;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_upd")
    public Date lastUpdatedDate;
}
