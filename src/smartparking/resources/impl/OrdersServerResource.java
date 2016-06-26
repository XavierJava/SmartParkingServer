package smartparking.resources.impl;

import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.OrderDao;
import smartparking.model.Order;
import smartparking.resources.OrdersResource;

import java.util.List;

public class OrdersServerResource extends ServerResource implements OrdersResource {
    private OrderDao orderDao;
    /**
     * URI某一用户id或某一停车场id
     */
    private String userIdOrParkingLotId;
    /**
     * URL查询参数,根据用户id还是停车场id
     */
    private String queryFor;
    /**
     * 一下两个参数指定某一用户在某一停车场的订单
     */
    private String userId;
    private String parkingLotId;
    /**
     * 页号
     */
    private String page;
    /**
     * 每页显示的项目数
     */
    private String count;

    @Override
    public void doInit() {
        super.doInit();
        userIdOrParkingLotId = getAttribute("userIdOrParkingLotId");
        userId = getAttribute("userId");
        parkingLotId = getAttribute("parkingLotId");
        queryFor = getQueryValue("q");
        page = getQueryValue("p");
        count = getQueryValue("c");
        orderDao = Settings.getOrderDao();
    }

    @Override
    public List<Order> getOrders() {
        int page = 1;
        long limit = 10l;
        long offset = 1;
        if (this.page != null && this.page.matches("^[0-9]*[1-9][0-9]*$")) {
            page = Integer.parseInt(this.page);
        }

        if (this.count != null && this.count.matches("^[0-9]*[1-9][0-9]*$")) {
            limit = Long.parseLong(this.count);
        }
        offset = (page - 1) * limit + 1;
        if (userIdOrParkingLotId == null) {
            return orderDao.getOrders(offset, limit);
        }
        if (queryFor.equals("user")) {
            return orderDao.getOrdersByUserId(Integer.parseInt(userIdOrParkingLotId), offset, limit);
        }
        if (queryFor.equals("parkingLot")) {
            return orderDao.getOrdersByParkingLotId(Integer.parseInt(userIdOrParkingLotId), offset, limit);
        }
        if (userId != null && parkingLotId != null) {
            return orderDao.getOrderByUserIdAndParkingLotId(Integer.parseInt(userId), Integer.parseInt(parkingLotId), offset, limit);
        } else
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
