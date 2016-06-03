package smartparking.server;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;
import smartparking.common.OrdersResource;
import smartparking.dao.OrderDaoImpl;
import smartparking.dao.SingleConnectionSource;
import smartparking.model.Order;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public class OrdersServerResource extends ServerResource implements OrdersResource {
    //CopyOnWriteArrayList
    int orderId = 0;
    OrderDaoImpl orderDao = null;

    @Override
    public void doInit() {
        super.doInit();
        String orderIdAttribute = getAttribute("orderId");
        System.out.println("订单id:" + orderIdAttribute);
        System.out.println(getQueryValue("xp"));
        try {
            this.orderDao = new OrderDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (orderIdAttribute != null) {
            this.orderId = Integer.parseInt(orderIdAttribute);
            setName("Resource for parking account '" + this.orderId + "'");
            setDescription("The resource describing the parking account number '"
                    + this.orderId + "'");
        } else {
            setName("parking account resource");
            setDescription("The resource describing a parking account");
        }
    }


    @Override
    public Representation getOrder() throws SQLException {//多个订单
        Order order = orderDao.getOrderById(orderId);
        return new JacksonRepresentation<Order>(order);
    }

    @Override
    public void addOrder(Representation rep) throws SQLException {
        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<Order>(
                rep, Order.class);
        Order order = null;
        try {
            order = orderRep.getObject();
            orderDao.addOrder(order);
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }
    }

    @Override
    public void removeOrder(int orderId) throws SQLException {
        orderDao.removeOrderById(orderId);
    }

    @Override
    public void editOrder(Representation rep) throws SQLException {
        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<Order>(
                rep, Order.class);
        Order order = null;
        try {
            order = orderRep.getObject();
            orderDao.editOrder(order);
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }
    }
}
