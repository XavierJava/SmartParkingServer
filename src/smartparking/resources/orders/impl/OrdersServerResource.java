package smartparking.resources.orders.impl;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.OrderDao;
import smartparking.model.Order;
import smartparking.resources.orders.OrdersResource;

import java.io.IOException;
import java.util.List;

public class OrdersServerResource extends ServerResource implements OrdersResource {
    private OrderDao orderDao;

    @Override
    public void doInit() {
        super.doInit();

        orderDao = Settings.getOrderDao();
    }


    @Override
    public Representation getOrders() {
        List orders = orderDao.getOrders();

        return new JacksonRepresentation<>(orders);
    }

    @Override
    public String addOrder(Representation rep) {
        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<>(
                rep, Order.class);

        Order order = null;

        try {
            order = orderRep.getObject();
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }

        return orderDao.addOrder(order) > 0 ? "新增成功" : "新增失败";
    }

    @Override
    public String updateOrder(Representation rep) {
        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<>(
                rep, Order.class);

        Order order = null;

        try {
            order = orderRep.getObject();
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }

        return orderDao.editOrder(order) > 0 ? "修改成功" : "修改失败";
    }
}
