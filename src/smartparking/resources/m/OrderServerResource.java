package smartparking.resources.m;

import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.OrderDao;
import smartparking.model.Order;
import smartparking.resources.common.m.OrderResource;

public class OrderServerResource extends ServerResource implements OrderResource {
    private OrderDao orderDao;

    private String orderId;

    @Override
    public void doInit() {
        super.doInit();

        orderDao = Settings.getOrderDao();

        orderId = getAttribute("orderId");

        System.out.println("订单id:" + orderId);
    }


    @Override
    public Order getOrder() {

        Order order = orderDao.getOrderById(Integer.parseInt(orderId));

        return order;
    }


    @Override
    public int removeOrder() {
        return orderDao.removeOrderById(Integer.parseInt(orderId));
    }
}
