package smartparking.resources.m;

import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.OrderDao;
import smartparking.model.Order;
import smartparking.resources.common.m.OrdersResource;

import java.util.List;

public class OrdersServerResource extends ServerResource implements OrdersResource {
    private OrderDao orderDao;
    private String userIdOrParkingLotId;
    private String q;
    private String userId;
    private String parkingLotId;

    @Override
    public void doInit() {
        super.doInit();
        userIdOrParkingLotId = getAttribute("userIdOrParkingLotId");
        q = getQueryValue("q");
        userId = getAttribute("userId");
        parkingLotId = getAttribute("parkingLotId");
        orderDao = Settings.getOrderDao();
    }

    @Override
    public List<Order> getOrders() {
        if (userIdOrParkingLotId == null)
            return orderDao.getOrders();
        if (q.equals("user"))
            return orderDao.getOrdersByUserId(Integer.parseInt(userIdOrParkingLotId));
        if (q.equals("parkingLot"))
            return orderDao.getOrdersByParkingLotId(Integer.parseInt(userIdOrParkingLotId));
        if (userId != null && parkingLotId != null)
            return orderDao.getOrderByUserIdAndParkingLotId(Integer.parseInt(userId), Integer.parseInt(parkingLotId));
        else
            return null;
    }

    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public int updateOrder(Order order) {

        return orderDao.updateOrder(order);
    }
}
