package smartparking.dao;

import smartparking.model.Order;

import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-20.
 */
public interface OrderDao {
    List<Order> getOrders();

    Order getOrderById(int OrderId);

    Order getOrderByUserIdAndParkingLotId(int userId, int parkingLotId);

    List<Order> getOrdersByUserId(int userId);

    List getOrdersByParkingLotId(int parkingLotId);

    int addOrder(Order order);

    int editOrder(Order order);

    int removeOrderById(int id);
}
