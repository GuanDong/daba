package beans;

/**
 * Created by hadoop on 2016/3/20.
 */
public class DistributeInfo {
    public String contactName;
    public String contectPhone;

    public String addressCity;
    public String addressBlock;
    public String addressUnit;
    public String addressDetail;

    public Double latitude;
    public Double longitude;

    public DistributeInfo(String contactName, String contectPhone,
                          String addressCity, String addressBlock, String addressUnit, String addressDetail,
                          Double latitude, Double longitude) {
        this.contactName = contactName;
        this.contectPhone = contectPhone;
        this.addressCity = addressCity;
        this.addressBlock = addressBlock;
        this.addressUnit = addressUnit;
        this.addressDetail = addressDetail;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
