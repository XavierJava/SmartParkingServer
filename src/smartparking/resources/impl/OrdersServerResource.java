package smartparking.resources.impl;

import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.OrderDao;
import smartparking.model.Order;
import smartparking.resources.OrdersResource;

import java.util.List;

/**
 * 订单的服务器资源
 */
public class OrdersServerResource extends ServerResource implements OrdersResource {
    private OrderDao orderDao;
    /**
     * URI中某一用户id或某一停车场id
     */
    private String userIdOrParkingLotId;
    /**
     * URL查询字段,根据用户id还是停车场id
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

    /**
     * 初始化资源
     */
    @Override
    public void doInit() {
        super.doInit();
        orderDao = Settings.getOrderDao();
        /**
         * 获取URI中的参数
         */
        userIdOrParkingLotId = getAttribute("userIdOrParkingLotId");
        userId = getAttribute("userId");
        parkingLotId = getAttribute("parkingLotId");
        /**
         * 获取URI后面的查询字段
         */
        queryFor = getQueryValue("q");
        page = getQueryValue("p");
        count = getQueryValue("c");
    }

    /**
     * 所有订单
     *
     * @return 订单对象的list
     */
    @Override
    public List<Order> getOrders() {
        int page = 1;//默认页号
        long limit = 10l;//每页的默认的显示数量
        long offset = 1;//默认偏移量
        /**
         * 根据设置和查询字段设置偏移量和每页的显示数量
         */
        if (this.page != null && this.page.matches("^[0-9]*[1-9][0-9]*$")) {
            page = Integer.parseInt(this.page);
        }

        if (this.count != null && this.count.matches("^[0-9]*[1-9][0-9]*$")) {
            limit = Long.parseLong(this.count);
        }
        offset = (page - 1) * limit + 1;
        /**
         * 根据参数执行查询计划
         */
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

    /**
     * 新建订单
     * @param order 将要新建订单的对象
     * @return 数据库分配给新订单的编号
     */
    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    /***
     * 更新订单
     * @param order 带有新信息的订单对象
     * @return 成功则1, 失败则0
     */
    @Override
    public int updateOrder(Order order) {

        return orderDao.updateOrder(order);
    }
}
