package controllers;

import play.mvc.Controller;
import play.mvc.With;
import soap.HUHU_spcCreate_spcContact_spcWeb_spcServiceStub;

import java.rmi.RemoteException;

@With(Application.class)
public class MyC extends Controller {

    public static void index() {
        render();
    }

    public static void createOrder() {
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

}
