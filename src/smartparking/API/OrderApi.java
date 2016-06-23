package smartparking.API;

import smartparking.model.Order;

import java.util.List;

public interface OrderApi {
    List<Order> getOrders();

    Order getOrderById(int OrderId);

    List<Order> getOrdersByUserId(int userId);

    List<Order> getOrdersByParkingLotId(int parkingLotId);

    List<Order> getOrderByUserIdAndParkingLotId(int userId, int parkingLotId);


    int addOrder(Order order);

    int updateOrder(Order order);

    int removeOrderById(int id);
}
