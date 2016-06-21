package smartparking.resources.orders.impl;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ServerResource;
import smartparking.SingleConnectionSource;
import smartparking.dao.impl.OrderDaoImpl;
import smartparking.resources.orders.UserOrdersResource;

import java.sql.SQLException;
import java.util.List;

/**
 * 某用户的所有订单.
 */
public class UserOrdersServerResource extends ServerResource implements UserOrdersResource {
    String userIdAttribute;
    OrderDaoImpl orderDao;

    @Override
    protected void doInit() {
        super.doInit();
        userIdAttribute = getAttribute("userId");
        System.out.println("用户id:" + userIdAttribute);
        try {
            orderDao = new OrderDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Representation getOrders() {
        if (userIdAttribute == null || !userIdAttribute.matches("^[0-9]*[1-9][0-9]*$"))
            return new StringRepresentation("参数错误");
        List orders = null;
        orders = orderDao.getOrdersByUserId(Integer.parseInt(userIdAttribute));
        return orders == null || orders != null && orders.size() <= 0 ? new StringRepresentation("用户尚无订单", MediaType.TEXT_PLAIN) :
                new JacksonRepresentation<>(orders);
    }
}
