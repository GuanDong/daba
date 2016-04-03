package jobs;

import consts.DabbawalConsts;
import controllers.Orders;
import models.OrderM;
import org.apache.commons.lang.StringUtils;
import play.Logger;
import play.jobs.Every;
import play.jobs.Job;
import utils.DateUtils;

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
                    Logger.error("自动取消过期订单失败: %s, 订单号: %s", result, order.id);
                }
            } catch (RemoteException e) {
                Logger.error(e, "自动取消过期订单失败.订单号: %s", order.id);
            }
        }
    }

}