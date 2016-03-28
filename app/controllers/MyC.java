package controllers;

import play.mvc.Controller;
import soap.*;

import java.rmi.RemoteException;

//@With(Application.class)
public class MyC extends Controller {

    public static void index() {
        render();
    }

    public static void modifyOrder() {
        render();
    }

    public static void viewOrder() {
        render();
    }

    public static void createContact(HUHU_spcCreate_spcContact_spcWeb_spcServiceStub.CreatedContact_Input contact) throws RemoteException {
        HUHU_spcCreate_spcContact_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcContact_spcWeb_spcServiceStub();
        HUHU_spcCreate_spcContact_spcWeb_spcServiceStub.CreatedContact_Output output = stub.createdContact(contact);
        renderJSON(output);
    }

    public static void createAddress(HUHU_spcCreate_spcAccount_spcAddress_spcWeb_spcServiceStub.CreatedAccountAddr_Input address) throws RemoteException {
        HUHU_spcCreate_spcAccount_spcAddress_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcAccount_spcAddress_spcWeb_spcServiceStub();
        HUHU_spcCreate_spcAccount_spcAddress_spcWeb_spcServiceStub.CreatedAccountAddr_Output output = stub.createdAccountAddr(address);
        renderJSON(output);
    }

    public static void takeCoupon(HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub.CreatedAccountCoupon_Input accountCoupon) throws RemoteException {
        HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub();
        HUHU_spcCreate_spcAccount_spcCoupon_spcWeb_spcServiceStub.CreatedAccountCoupon_Output output = stub.createdAccountCoupon(accountCoupon);
        renderJSON(output);
    }

    public static void createOrder(HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Input order, HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.OrderEntryLineItems product, HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.OrderEntryLineItems coupon) throws RemoteException {
        HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.ListOfHuhuOrderLineMessage lineMessage = new HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.ListOfHuhuOrderLineMessage();
        HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.ListOforderEntryLineItems orderEntryLineItems = new HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.ListOforderEntryLineItems();
        orderEntryLineItems.addOrderEntryLineItems(product);
        orderEntryLineItems.addOrderEntryLineItems(coupon);
        lineMessage.setListOforderEntryLineItems(orderEntryLineItems);
        order.setListOfHuhuOrderLineMessage(lineMessage);
        HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub();
        HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output output = stub.createdOrder(order);
        renderJSON(output);
    }

    public static void payOrder(HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub.ChangeOrderstatus_Input order) throws RemoteException {
        HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub stub = new HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub();
        HUHU_spcChange_spcOrder_spcStatus_spcWeb_spcServiceStub.ChangeOrderstatus_Output output = stub.changeOrderstatus(order);
        renderJSON(output);
    }

    public static void evaluateProduct(HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub.CreatedProdEva_Input evaluate) throws RemoteException {
        HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub stub = new HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub();
        HUHU_spcCreate_spcProduct_spcEvaluate_spcWeb_spcServiceStub.CreatedProdEva_Output output = stub.createdProdEva(evaluate);
        renderJSON(output);
    }

}
