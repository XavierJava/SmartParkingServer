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
    public List<Order> getOrders(long offset, long limit) {
        try {
            return queryBuilder().offset(offset).limit(limit).query();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Order> getOrderByUserIdAndParkingLotId(int userId, int parkingLotId, long offset, long limit) {
        QueryBuilder<Order, Integer> queryBuilder = this.queryBuilder();
        Where<Order, Integer> where = queryBuilder.where();

        try {
            where.and(where.eq("id_user", userId), where.eq("id_lot", parkingLotId));
            PreparedQuery<Order> preparedQuery = queryBuilder.offset(offset).limit(limit).prepare();
            return query(preparedQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Order> getOrdersByUserId(int userId, long offset, long limit) {
        QueryBuilder<Order, Integer> queryBuilder = this.queryBuilder();
        Where<Order, Integer> where = queryBuilder.where();
        try {
            where.eq("id_user", userId);
            PreparedQuery<Order> preparedQuery = queryBuilder.offset(offset).limit(limit).prepare();
            return this.query(preparedQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Order> getOrdersByParkingLotId(int parkingLotId, long offset, long limit) {
        QueryBuilder<Order, Integer> queryBuilder = this.queryBuilder();
        Where<Order, Integer> where = queryBuilder.where();
        try {
            where.eq("id_user", parkingLotId);
            PreparedQuery<Order> preparedQuery = queryBuilder.offset(offset).limit(limit).prepare();
            return this.query(preparedQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Order getOrderById(int OrderId) {
        try {
            return queryForId(OrderId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int addOrder(Order order) {
        try {
            return create(order);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateOrder(Order order) {
        try {
            return update(order);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int removeOrderById(int id) {
        try {
            return deleteById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
