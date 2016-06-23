package smartparking.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.dao.OrderDao;
import smartparking.model.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl<Order, Integer> implements OrderDao {
    public OrderDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Order.class);
    }

    @Override
    public List<Order> getOrders() {
        List<Order> list = null;

        try {
            list = queryForAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Order getOrderById(int OrderId) {
        Order order = null;
        try {
            order = queryForId(OrderId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @Override
    public List<Order> getOrderByUserIdAndParkingLotId(int userId, int parkingLotId) {
        List<Order> orderList = null;
        QueryBuilder<Order, Integer> queryBuilder = this.queryBuilder();
        Where<Order, Integer> where = queryBuilder.where();

        try {
            where.and(where.eq("id_user", userId), where.eq("id_lot", parkingLotId));
            PreparedQuery<Order> preparedQuery = queryBuilder.prepare();
            orderList = this.query(preparedQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orderList;

    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> list = null;
        try {
            list = queryForEq("id_user", userId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public List<Order> getOrdersByParkingLotId(int parkingLotId) {
        List<Order> list = null;
        try {
            list = queryForEq("id_lot", parkingLotId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public int addOrder(Order order) {
        int flag = 0;
        try {
            flag = create(order);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @Override
    public int updateOrder(Order order) {
        int flag = 0;
        try {
            flag = update(order);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @Override
    public int removeOrderById(int id) {
        int flag = 0;
        try {
            flag = deleteById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
