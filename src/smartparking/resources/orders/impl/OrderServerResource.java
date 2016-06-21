package smartparking.resources.orders.impl;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.OrderDao;
import smartparking.model.Order;
import smartparking.resources.orders.OrderResource;

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
    public Representation getOrder() {
        if (orderId == null || !orderId.matches("^[0-9]*[1-9][0-9]*$"))
            return new StringRepresentation("参数类型错误");

        Order order = orderDao.getOrderById(Integer.parseInt(orderId));

        return order != null ? new JacksonRepresentation<>(order) : new StringRepresentation("没有该订单");
    }

    @Override
    public String removeOrder() {
        if (orderId == null || !orderId.matches("^[0-9]*[1-9][0-9]*$"))
            return "参数类型错误";

        return orderDao.removeOrderById(Integer.parseInt(orderId)) > 0 ? "删除成功" : "删除失败";
    }
}
