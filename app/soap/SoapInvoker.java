package soap;

import me.chanjar.weixin.common.util.StringUtils;
import play.Logger;
import soap.HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub.ChangeOrderstatus_Input;
import soap.HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub.ChangeOrderstatus_Output;
import soap.HUHU_spcCreate_spcAccount_spcAddress_spcWeb_spcServiceStub.CreatedAccountAddr_Input;
import soap.HUHU_spcCreate_spcAccount_spcAddress_spcWeb_spcServiceStub.CreatedAccountAddr_Output;
import soap.HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub.CreatedAccountCoupon_Input;
import soap.HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub.CreatedAccountCoupon_Output;
import soap.HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub.CreatedAccount_Input;
import soap.HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub.CreatedAccount_Output;
import soap.HUHU_spcCreate_spcContact_spcWeb_spcServiceStub.CreatedContact_Input;
import soap.HUHU_spcCreate_spcContact_spcWeb_spcServiceStub.CreatedContact_Output;
import soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.*;
import soap.HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub.CreatedProdEva_Input;
import soap.HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub.CreatedProdEva_Output;

import java.rmi.RemoteException;


/**
 * Created by gchuyun on 16/4/1.
 */
public class SoapInvoker {

    public static CreatedAccount_Output saveAccount(CreatedAccount_Input account) throws RemoteException {
        HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub();
        CreatedAccount_Output output = stub.createdAccount(account);
        return output;
    }

    public static CreatedAccountCoupon_Output takeCoupon(CreatedAccountCoupon_Input accountCoupon) throws RemoteException {
        HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub();
        CreatedAccountCoupon_Output output = stub.createdAccountCoupon(accountCoupon);
        return output;
    }

    public static CreatedOrder_Output saveOrder(CreatedOrder_Input order, String productId, String couponId) throws RemoteException {
        Logger.info("productId: %s, couponId:%s", productId, couponId);

        ListOfHuhuOrderLineMessage lineMessage = new ListOfHuhuOrderLineMessage();
        ListOforderEntryLineItems orderEntryLineItems = new ListOforderEntryLineItems();
        OrderEntryLineItems product = new OrderEntryLineItems();
        product.setItemid(productId);
        product.setProducttype("产品");
        orderEntryLineItems.addOrderEntryLineItems(product);
        if (!StringUtils.isBlank(couponId)) {
            Logger.info("couponId:%s", couponId);
            OrderEntryLineItems coupon = new OrderEntryLineItems();
            coupon.setItemid(couponId);
            coupon.setProducttype("促销");
            orderEntryLineItems.addOrderEntryLineItems(coupon);
        }
        lineMessage.setListOforderEntryLineItems(orderEntryLineItems);

        order.setListOfHuhuOrderLineMessage(lineMessage);
        HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub();
        CreatedOrder_Output output = stub.createdOrder(order);
        return output;
    }

    public static ChangeOrderstatus_Output changeOrderStatus(String orderId, String status) throws RemoteException {
        ChangeOrderstatus_Input statusInput = new ChangeOrderstatus_Input();
        statusInput.setOrderid(orderId);
        statusInput.setStatus(status);
        HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub stub = new HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub();
        ChangeOrderstatus_Output output = stub.changeOrderstatus(statusInput);
        return output;
    }

    public static CreatedProdEva_Output commentProduct(CreatedProdEva_Input evaluate) throws RemoteException {
        HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub();
        CreatedProdEva_Output output = stub.createdProdEva(evaluate);
        return output;
    }

    public static CreatedContact_Output saveContact(CreatedContact_Input contact) throws RemoteException {
        HUHU_spcCreate_spcContact_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcContact_spcWeb_spcServiceStub();
        CreatedContact_Output output = stub.createdContact(contact);
        return output;
    }

    public static CreatedAccountAddr_Output saveAddress(CreatedAccountAddr_Input address) throws RemoteException {
        HUHU_spcCreate_spcAccount_spcAddress_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcAccount_spcAddress_spcWeb_spcServiceStub();
        CreatedAccountAddr_Output output = stub.createdAccountAddr(address);
        return output;
    }
}
