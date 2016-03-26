package utils;

import org.apache.commons.lang.StringUtils;
import play.Logger;
import play.Play;
import play.libs.Codec;

import java.util.Arrays;

/**
 * Created by gchuyun on 16/3/26.
 */
public class WeiXinUtils {

    public static boolean checkSignature(String signature, String
            timestamp, String nonce) {
        String token = Play.configuration.getProperty("weixin.token");

        String[] arr = new String[]{token, timestamp, nonce};
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String tmpStr = Codec.hexSHA1(content.toString());

        Logger.debug("token: %s, sign: %s, tmp: %s", token, signature, tmpStr);
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null && StringUtils.equalsIgnoreCase(tmpStr, signature);
    }
}
