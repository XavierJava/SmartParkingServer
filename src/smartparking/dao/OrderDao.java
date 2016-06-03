package smartparking.dao;

import smartparking.model.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-20.
 */
public interface OrderDao {
    List<Order> getOrders() throws SQLException;

    Order getOrderById(int OrderId) throws SQLException;

    Order getOrderByUserIdAndParkingLotId(int userId, int parkingLotId);

    List<Order> getOrdersByUserId(int userId) throws SQLException;

    List getOrdersByParkingLotId(int parkingLotId) throws SQLException;

    void addOrder(Order order) throws SQLException;

    void editOrder(Order order) throws SQLException;

    void removeOrderById(int id) throws SQLException;
}
