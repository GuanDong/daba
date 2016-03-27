package jobs;

import controllers.WechatC;
import me.chanjar.weixin.common.exception.WxErrorException;
import play.jobs.*;

@OnApplicationStart
public class WechatMenuJob extends Job {

    public void doJob() {
        try {
            WechatC.createMenu();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

}