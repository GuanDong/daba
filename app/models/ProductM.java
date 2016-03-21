package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="huhu_prod_list_v")
public class ProductM extends GenericModel {

    @Id
    @Column(name="row_id")
    public String id;

    @Column(name="name")
    public String name;

    @Column(name="part_num")
    public String partNum;

    @Column(name="dest_text")
    public String desc;

    @Column(name="product_level")
    public Integer laLevel;

    @Column(name="prod_hod")
    public Integer hotLevel;

    @Column(name="prod_eva")
    public Integer evaLevel;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_upd")
    public Date lastUpdatedDate;
}
