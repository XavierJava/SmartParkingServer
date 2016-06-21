package smartparking.resources.orders.impl;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ServerResource;
import smartparking.Settings;
import smartparking.dao.OrderDao;
import smartparking.resources.orders.UserOrdersResource;

import java.util.List;

/**
 * 某用户的所有订单.
 */
public class UserOrdersServerResource extends ServerResource implements UserOrdersResource {
    private OrderDao orderDao;

    private String userId;

    @Override
    protected void doInit() {
        super.doInit();

        orderDao = Settings.getOrderDao();

        userId = getAttribute("userId");

        System.out.println("用户id:" + userId);
    }

    @Override
    public Representation getOrders() {
        if (userId == null || !userId.matches("^[0-9]*[1-9][0-9]*$"))
            return new StringRepresentation("参数错误");

        List orders = orderDao.getOrdersByUserId(Integer.parseInt(userId));

        return orders == null || orders.size() <= 0 ? new StringRepresentation("用户尚无订单", MediaType.TEXT_PLAIN) :
                new JacksonRepresentation<>(orders);
    }
}
