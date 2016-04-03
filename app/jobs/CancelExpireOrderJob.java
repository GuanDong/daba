package jobs;

import consts.DabbawalConsts;
import controllers.Orders;
import controllers.Wechat;
import me.chanjar.weixin.common.exception.WxErrorException;
import models.OrderM;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import play.Logger;
import play.jobs.Every;
import play.jobs.Job;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

@Every("1min")
public class CancelExpireOrderJob extends Job {

    public void doJob() {
        List<OrderM> orderList = OrderM.find("createdDate <= ? and status = ?", DateUtils.addMinutes(new Date(), -30), DabbawalConsts.ORDER_STATUS_NEW).fetch();

        for (OrderM order : orderList){
            try {
                String result = Orders.cancelOrder(order.id);
                if (!StringUtils.equals(DabbawalConsts.RESPONSE_RESULT_SUCCESS, result)) {
                    Logger.error("自动取消过期订单失败: %s", result);
                }
            } catch (RemoteException e) {
                Logger.error(e, "自动取消过期订单失败.");
            }
        }
    }

}