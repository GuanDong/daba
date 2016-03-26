package controllers;

import org.apache.commons.lang.StringUtils;
import play.mvc.*;
import play.mvc.results.Error;
import utils.WeiXinUtils;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Application extends Controller {

    public static void index() {
        render();
        ProductsC.list(null);
    }

    public static void token(){
        // 微信加密签名
        String signature = params.get("signature");
        // 随机字符串
        String echostr = params.get("echostr");
        // 时间戳
        String timestamp = params.get("timestamp");
        // 随机数
        String nonce = params.get("nonce");

        // 通过检验signature对请求进行校验，若校验成功则原样
        // 返回echostr，表示接入成功，否则接入失败
        if (StringUtils.isBlank(signature)) {
            error("wechat param not found");
        } else if (WeiXinUtils.checkSignature(signature,timestamp,
                nonce)) {
            renderText(echostr);
        }

    }

    public static void login() {
        render();
    }

    public static void logout() {
        render();
    }

    public static void follow() {
        render();
    }

    public static void unfollow() {
        render();
    }

    public static void notice() {
        render();
    }

}