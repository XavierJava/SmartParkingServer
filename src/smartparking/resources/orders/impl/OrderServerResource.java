package smartparking.resources.orders.impl;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ServerResource;
import smartparking.SingleConnectionSource;
import smartparking.dao.impl.OrderDaoImpl;
import smartparking.model.Order;
import smartparking.resources.orders.OrderResource;

import java.sql.SQLException;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public class OrderServerResource extends ServerResource implements OrderResource {
    //CopyOnWriteArrayList
    String orderIdAttribute;
    OrderDaoImpl orderDao = null;

    @Override
    public void doInit() {
        super.doInit();
        orderIdAttribute = getAttribute("orderId");
        System.out.println("订单id:" + orderIdAttribute);
        try {
            this.orderDao = new OrderDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public Representation getOrder() {
        if (orderIdAttribute == null || !orderIdAttribute.matches("^[0-9]*[1-9][0-9]*$"))
            return new StringRepresentation("参数类型错误");
        Order order = orderDao.getOrderById(Integer.parseInt(orderIdAttribute));
        return order != null ? new JacksonRepresentation<>(order) : new StringRepresentation("没有该订单");
    }

    @Override
    public String removeOrder() {
        if (orderIdAttribute == null || !orderIdAttribute.matches("^[0-9]*[1-9][0-9]*$"))
            return "参数类型错误";
        return orderDao.removeOrderById(Integer.parseInt(orderIdAttribute)) > 0 ? "删除成功" : "删除失败";
    }
}
