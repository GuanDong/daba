package beans;

/**
 * Created by hadoop on 2016/3/20.
 */
public class DistributeInfo {
    public String contactId;
    public String contactName;
    public String contectPhone;

    public String addressId;
    public String addressCity;
    public String addressBlock;
    public String addressUnit;
    public String addressDetail;

    public Double latitude;
    public Double longitude;

    public DistributeInfo(String contactId, String contactName, String contectPhone,
                          String addressId, String addressCity, String addressBlock, String addressUnit, String addressDetail,
                          Double latitude, Double longitude) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contectPhone = contectPhone;
        this.addressId = addressId;
        this.addressCity = addressCity;
        this.addressBlock = addressBlock;
        this.addressUnit = addressUnit;
        this.addressDetail = addressDetail;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
