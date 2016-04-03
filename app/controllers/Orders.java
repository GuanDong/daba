package controllers;

import beans.ResponseResult;
import com.google.gson.Gson;
import me.chanjar.weixin.common.exception.WxErrorException;
import models.AccountCouponM;
import models.CouponM;
import models.OrderM;
import models.ProductM;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import play.Logger;
import play.cache.Cache;
import soap.HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub;
import soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub;
import soap.HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub;
import soap.SoapInvoker;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Orders extends Base {

    public static void evaluate(String productId, String couponId) {
        ProductM product = ProductM.findById(productId);
        AccountCouponM myCoupon = AccountCouponM.findById(couponId);
        if (product != null && myCoupon != null){
            CouponM coupon = CouponM.findById(myCoupon.couponId);
            if (coupon != null){
                renderJSON(product.stdPrice - 3);
            }
            renderJSON(product.stdPrice);
        }

        renderJSON(-1);
    }

    public static void create(String productId, String couponId,
                              HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Input order) throws RemoteException {
        String location = Cache.get(getAccountOpenId() + "_location", String.class);
        if (!StringUtils.isBlank(location)) {
            String[] longLat = location.split("-");
            order.setLongtitude(longLat[0]);
            order.setLatitude(longLat[1]);
        }
        order.setAccntid(getAccountOpenId());
        HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output output = SoapInvoker.saveOrder(order, productId, couponId);
        if (StringUtils.equals("S", output.getProcStatus())) {
            String orderId = output.getOrderid();
            pay(orderId);
        } else {
            Logger.error(output.getProcMsg());
            Products.book(params.get("product"));
        }
    }

    public static void pay(String orderId) {
        OrderM order = OrderM.findById(orderId);
        ResponseResult result = new ResponseResult();
        try {
            Map<String, String> jssdkPayInfo = Wechat.getJSSDKPayInfo(request.remoteAddress, order);
            result.setResult(jssdkPayInfo);
//            renderJSON(result);
            render(order, jssdkPayInfo);
        } catch (WxErrorException e) {
            render(e);
//            result.setError(e.getError().getErrorMsg());
//            renderJSON(result);
        }
    }

    public static void cancel(String orderId) throws RemoteException {
        HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub.ChangeOrderstatus_Output output = SoapInvoker.changeOrderStatus(orderId, "已取消");
        if (StringUtils.equals("S", output.getProcStatus())) {
            renderJSON("SUCCESS");
        } else {
            renderJSON(output.getProcMsg());
        }
    }

    public static void comment(String orderId, Integer score, String content) throws RemoteException {
        OrderM order = OrderM.find("accountId = ? and id = ?", getAccountOpenId(), orderId).first();
        if (order == null){
            renderText("订单不存在");
        }
        HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub.CreatedProdEva_Input comment = new HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub.CreatedProdEva_Input();
        comment.setAccntid(getAccountOpenId());
        comment.setOrderid(orderId);
        comment.setProdid("五花肉");
        comment.setProdrate(score.toString());
        comment.setProdevadesc(content);

        HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub.CreatedProdEva_Output output = SoapInvoker.commentProduct(comment);
        if (StringUtils.equals("S", output.getProcStatus())){
            renderText("SUCCESS");
        } else {
            renderText(output.getProcMsg());
        }
    }

}
