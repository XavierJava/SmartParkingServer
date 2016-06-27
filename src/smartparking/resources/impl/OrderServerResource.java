package smartparking.resources.impl;

import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.OrderDao;
import smartparking.model.Order;
import smartparking.resources.OrderResource;

/**
 * 订单的服务器资源
 */
public class OrderServerResource extends ServerResource implements OrderResource {
    private OrderDao orderDao;
    private String orderId;//订单编号

    /**
     * 初始化资源
     */
    @Override
    public void doInit() {
        super.doInit();
        orderDao = Settings.getOrderDao();
        orderId = getAttribute("orderId");//获取URI中的参数
    }

    /**
     * 获取指定编号的订单
     *
     * @return 订单对象
     */
    @Override
    public Order getOrder() {

        Order order = orderDao.getOrderById(Integer.parseInt(orderId));

        return order;
    }

    /**
     * 删除指定编号的订单
     * @return 删除成功1, 失败0
     */

    @Override
    public int removeOrder() {
        return orderDao.removeOrderById(Integer.parseInt(orderId));
    }
}
