package smartparking.common;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.dao.OrderDao;
import smartparking.dao.ParkingLotDao;
import smartparking.dao.UserDao;
import smartparking.dao.impl.OrderDaoImpl;
import smartparking.dao.impl.ParkingLotDaoImpl;
import smartparking.dao.impl.UserDaoImpl;

import java.sql.SQLException;

public class Settings {
    private static final String databaseUrl = "jdbc:mysql://localhost:3306/smartparking";
    private static final String username = "root";
    private static final String password = "chenhuan";

    public static final String SERVER_HOST = "http://localhost:8111";

    private static ConnectionSource connectionSource;

    private static ParkingLotDao parkingLotDao;
    private static UserDao userDao;
    private static OrderDao orderDao;

    static {
        try {
            connectionSource = new JdbcConnectionSource(databaseUrl, username, password);

            parkingLotDao = new ParkingLotDaoImpl(connectionSource);
            userDao = new UserDaoImpl(connectionSource);
            orderDao = new OrderDaoImpl(connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public static ParkingLotDao getParkingLotDao() {
        return parkingLotDao;
    }

    public static UserDao getUserDao() {
        return userDao;
    }

    public static OrderDao getOrderDao() {
        return orderDao;
    }
}
