package smartparking.api;

import smartparking.model.Order;

import java.util.List;

/**
 * 订单api
 */


public interface OrderApi {
    /**
     * @return
     */
    Order getOrderById(int OrderId);

    List<Order> getOrders(int page, int count);

    List<Order> getOrdersByUserId(int userId, int page, int count);

    List<Order> getOrdersByParkingLotId(int parkingLotId, int page, int count);

    List<Order> getOrderByUserIdAndParkingLotId(int userId, int parkingLotId, int page, int count);

    int addOrder(Order order);

    int updateOrder(Order order);

    int removeOrderById(int id);
}
