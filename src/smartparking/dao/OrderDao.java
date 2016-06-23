package smartparking.dao;

import smartparking.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrders();

    Order getOrderById(int OrderId);

    List<Order> getOrderByUserIdAndParkingLotId(int userId, int parkingLotId);

    List<Order> getOrdersByUserId(int userId);

    List<Order> getOrdersByParkingLotId(int parkingLotId);

    int addOrder(Order order);

    int updateOrder(Order order);

    int removeOrderById(int id);
}
