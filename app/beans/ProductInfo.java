package beans;

/**
 * Created by hadoop on 2016/3/20.
 */
public class ProductInfo {
    public String id;
    public String name;
    public String desc;
    public int laLevel;
    public int hotLevel;
    public int evaLeval;
    public float price;

    public ProductInfo(String id, String name, String desc, int laLevel, int hotLevel, int evaLeval, float price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.laLevel = laLevel;
        this.hotLevel = hotLevel;
        this.evaLeval = evaLeval;
        this.price = price;
    }
}
