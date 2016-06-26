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
    private static final String databaseUrl = "jdbc:mysql://localhost:3306/smartparking?useUnicode=true&characterEncoding=UTF-8";
    private static final String username = "root";
    private static final String password = "chenhuan";

    private static ParkingLotDao parkingLotDao;
    private static UserDao userDao;
    private static OrderDao orderDao;
    private static ConnectionSource connectionSource;

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

    public static synchronized ParkingLotDao getParkingLotDao() {
        return parkingLotDao;
    }

    public static synchronized UserDao getUserDao() {
        return userDao;
    }

    public static synchronized OrderDao getOrderDao() {
        return orderDao;
    }
}
