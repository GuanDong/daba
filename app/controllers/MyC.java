package controllers;

import com.google.gson.Gson;
import play.Logger;
import play.mvc.*;
import soap.HUHU_spcCreate_spcContact_spcWeb_spcServiceStub;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

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
