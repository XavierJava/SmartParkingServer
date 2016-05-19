package smartparking.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.model.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-19.
 */
public class OrderDaoImpl extends BaseDaoImpl<Order, Integer> {
    public OrderDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Order.class);
    }

    //get all orders
    public List<Order> getOrders() throws SQLException {
        return super.queryForAll();
    }

    public Order getOrderById(int OrderId) throws SQLException {
        return super.queryForId(OrderId);
    }

    public List<Order> getOrderByUserId(int userId) throws SQLException {
        return super.queryForEq("id_user", userId);
    }

    public List getOrderByParkingLotId(int parkingLotId) throws SQLException {
        return super.queryForEq("lot_id", parkingLotId);
    }

    public void addOrder(Order order) throws SQLException {
        super.create(order);
    }

    public void editOrder(Order order) throws SQLException {
        super.update(order);
    }

    public void removeOrderById(int id) throws SQLException {
        super.deleteById(id);
    }
}
