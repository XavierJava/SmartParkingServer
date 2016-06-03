package smartparking.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.model.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl<Order, Integer> implements OrderDao {
    public OrderDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Order.class);
    }

    @Override
    public List<Order> getOrders() throws SQLException {
        return super.queryForAll();
    }

    @Override
    public Order getOrderById(int OrderId) throws SQLException {
        return super.queryForId(OrderId);
    }

    @Override
    public Order getOrderByUserIdAndParkingLotId(int userId, int parkingLotId) {
        List<Order> orderList = null;
        QueryBuilder<Order, Integer> queryBuilder = this.queryBuilder();
        Where<Order, Integer> where = queryBuilder.where();

        try {
            where.and(where.eq("id_user", userId), where.eq("id_lot", parkingLotId));
            PreparedQuery preparedQuery = queryBuilder.prepare();
            orderList = this.query(preparedQuery);
        } catch (SQLException e) {
        }
        if (orderList == null || orderList.size() < 1)
            return null;
        else
            return orderList.get(0);

    }

    @Override
    public List<Order> getOrdersByUserId(int userId) throws SQLException {
        return super.queryForEq("id_user", userId);
    }

    @Override
    public List getOrdersByParkingLotId(int parkingLotId) throws SQLException {
        return super.queryForEq("lot_id", parkingLotId);
    }

    @Override
    public void addOrder(Order order) throws SQLException {
        super.create(order);
    }

    @Override
    public void editOrder(Order order) throws SQLException {
        super.update(order);
    }

    @Override
    public void removeOrderById(int id) throws SQLException {
        super.deleteById(id);
    }
}
