package jobs;

import controllers.WechatC;
import me.chanjar.weixin.common.exception.WxErrorException;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class WechatMenuJob extends Job {

    public void doJob() {
        try {
            WechatC.init();
            WechatC.createMenu();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

}