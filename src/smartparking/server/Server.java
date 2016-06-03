package smartparking.server;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.dao.OrderDaoImpl;
import smartparking.dao.ParkingLotDaoImpl;
import smartparking.dao.UserDaoImpl;

import java.io.IOException;
import java.sql.SQLException;

public class Server {
    public static void main(String[] args) throws SQLException, IOException {
        String databaseUrl = "jdbc:mysql://localhost:3306/smartparking";
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "chenhuan");
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(connectionSource);
        UserDaoImpl userDao = new UserDaoImpl(connectionSource);
        OrderDaoImpl orderDao = new OrderDaoImpl(connectionSource);
        connectionSource.close();
    }
}
