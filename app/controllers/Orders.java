package controllers;

import me.chanjar.weixin.common.exception.WxErrorException;
import models.AccountCouponM;
import models.CouponM;
import models.OrderM;
import models.ProductM;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import soap.HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub;
import soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub;
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

        HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output output = SoapInvoker.saveOrder(order, productId, couponId);
        if (StringUtils.equals("SUCCESS", output.getProcStatus())) {
            String orderId = output.getOrderid();
            pay(orderId);
        } else {
            flash.error("error", output.getProcMsg());
            Products.book(productId);
        }
    }

    public static void pay(String orderId) {
        OrderM orderM = OrderM.findById(orderId);
        try {
            Map<String, String> jssdkPayInfo = Wechat.getJSSDKPayInfo(request.host, orderM);
            render(jssdkPayInfo);
        } catch (WxErrorException e) {
            render(e);
        }
    }

    public static void cancel(String orderId) throws RemoteException {
        HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub.ChangeOrderstatus_Output output = SoapInvoker.changeOrderStatus(orderId, "已取消");
        if (StringUtils.equals("SUCCESS", output.getProcStatus())) {
            renderJSON("SUCCESS");
        } else {
            renderJSON(output.getProcMsg());
        }
    }

    public static void comment(String orderId, Integer score, String content) {
        OrderM order = OrderM.find("accountId = ? and orderId = ?", getAccountOpenId(), orderId).first();
        if (order != null && order.evaluateScore != null) {
            order.evaluateScore = score;
            order.evaluateContent = content;
//            HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output output = SoapInvoker.saveOrder(orderIt);
//            if (StringUtils.equals("SUCCESS", output.getProcStatus())){
//                renderJSON("SUCCESS");
//            } else {
//                renderJSON(output.getProcMsg());
//            }
        }
    }

}
