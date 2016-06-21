package smartparking.resources.orders.impl;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;
import smartparking.SingleConnectionSource;
import smartparking.dao.impl.OrderDaoImpl;
import smartparking.model.Order;
import smartparking.resources.orders.OrdersResource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OrdersServerResource extends ServerResource implements OrdersResource {
    OrderDaoImpl orderDao = null;

    @Override
    public void doInit() {
        super.doInit();
        try {
            this.orderDao = new OrderDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public Representation getOrders() {
        List orders = orderDao.getOrders();
        return new JacksonRepresentation<>(orders);
    }

    @Override
    public String addOrder(Representation rep) {
        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<Order>(
                rep, Order.class);
        Order order = null;
        try {
            order = orderRep.getObject();
        } catch (IOException E) {
            System.out.println(E.getMessage());
            //setStatus(Status.SERVER_ERROR_INTERNAL,"服务器内部错误");
        }
        return orderDao.addOrder(order) > 0 ? "新增成功" : "新增失败";
    }

    @Override
    public String updateOrder(Representation rep) {
        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<Order>(
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
