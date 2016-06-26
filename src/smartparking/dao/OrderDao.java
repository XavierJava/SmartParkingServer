package smartparking.dao;

import smartparking.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrders(long offset, long limit);

    Order getOrderById(int OrderId);

    List<Order> getOrderByUserIdAndParkingLotId(int userId, int parkingLotId, long offset, long limit);

    List<Order> getOrdersByUserId(int userId, long offset, long limit);

    List<Order> getOrdersByParkingLotId(int parkingLotId, long offset, long limit);

    int addOrder(Order order);

    int updateOrder(Order order);

    int removeOrderById(int id);
}
