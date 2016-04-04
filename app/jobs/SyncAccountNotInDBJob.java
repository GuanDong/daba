package jobs;

import controllers.Wechat;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import play.Logger;
import play.db.jpa.JPA;
import play.jobs.Every;
import play.jobs.Job;
import play.jobs.On;
import play.jobs.OnApplicationStart;
import soap.HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub;
import soap.SoapInvoker;

import java.rmi.RemoteException;
import java.util.List;

@OnApplicationStart
//@On("0 0 3 * * ?")
public class SyncAccountNotInDBJob extends Job {

    public void doJob() {
        Wechat.init();
        List existOpenIdList = JPA.em().createQuery("select openId from AccountM").getResultList();

        int count = 1;
        String nextId = null;
        while (count > 0) {
            try {
                WxMpUserList userList = Wechat.getUserList(nextId);
                count = userList.getCount();
                nextId = userList.getNextOpenId();

                for (String openId : userList.getOpenIds()) {
                    if (!existOpenIdList.contains(openId)) {
                        try {
                            WxMpUser user = Wechat.getUserInfo(openId);

                            HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub.CreatedAccount_Input account = new HUHU_spcCreate_spcAccount_spcWeb_spcServiceStub.CreatedAccount_Input();
                            account.setIntegrationid(user.getOpenId());
                            account.setAliasname(user.getNickname());
                            account.setLoc(user.getCity());
                            account.setReserve1(user.getSex());
                            account.setReserve2(user.getHeadImgUrl());

                            SoapInvoker.saveAccount(account);
                        } catch (WxErrorException e) {
                            Logger.error(e, "同步数据库没有的用户失败.");
                        } catch (RemoteException e) {
                            Logger.error(e, "同步数据库没有的用户失败.");
                        }
                    }
                }
            } catch (WxErrorException e) {
                Logger.error(e, "同步数据库没有的用户失败.");
            }
        }

    }

}