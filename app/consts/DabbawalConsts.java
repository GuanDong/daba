package consts;

import play.Play;

/**
 * Created by hadoop on 2016/3/20.
 */
public class DabbawalConsts {
    public static final String RESPONSE_RESULT_SUCCESS="S";
    public static final String RESPONSE_RESULT_ERROR="E";

    public static final String COUPON_USE_FLAG_YES="Y";
    public static final String COUPON_USE_FLAG_NO="N";

    public static final String ORDER_STATUS_NEW="待定";
    public static final String ORDER_STATUS_CANCELD="已取消";
    public static final String ORDER_STATUS_PAIED="已支付";
    public static final String ORDER_STATUS_SENT="已发货";
    public static final String ORDER_STATUS_FINISHED="已完成";

    public static final String PRODUCT_TYPE_PROD="产品";
    public static final String PRODUCT_TYPE_COUPON="促销";

    public static final String SUBSCRIBE_NEWS_ID = "VeIz1NC9aohU2iHDYgE2lLII9NPWVT-9LTPaKgkHLS4";
    public static final String ABOUT_PAGE_URL = "http://mp.weixin.qq.com/s?__biz=MzAxMjgwMDQ5Ng==&mid=404065631&idx=1&sn=bf4726e2eaf5ea40fb2cd3a8f2049e3f&scene=1&srcid=03303cuqBlcvYmovASd9JV38#rd";

    public static final String RESOURCE_VERSION = Play.configuration.getProperty("resource.version");;
}
