package jobs;

import controllers.Wechat;
import me.chanjar.weixin.common.exception.WxErrorException;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class WechatMenuJob extends Job {

    public void doJob() {
        try {
            Wechat.init();
            Wechat.createMenu();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

}