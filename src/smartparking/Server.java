package smartparking;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.api.ApiImpl;
import smartparking.dao.OrderDaoImpl;
import smartparking.dao.ParkingLotDaoImpl;
import smartparking.dao.UserDaoImpl;
import smartparking.model.ParkingLot;

import java.io.IOException;
import java.sql.SQLException;

public class Server {
    public static void main(String[] args) throws SQLException, IOException {
        System.out.println("Welcome to SmartParking Server.");
        String databaseUrl = "jdbc:mysql://localhost:3306/smartparking";
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "chenhuan");
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(connectionSource);
        UserDaoImpl userDao = new UserDaoImpl(connectionSource);
        OrderDaoImpl orderDao = new OrderDaoImpl(connectionSource);
        //TableUtils.createTableIfNotExists(connectionSource, Order.class);
        //TableUtils.createTableIfNotExists(connectionSource, ParkingLot.class);
        // TableUtils.createTableIfNotExists(connectionSource, Order.class);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("北工大南门停车场");
        parkingLot.setAddress("北京北京市平乐园100号");
        parkingLot.setAvailableSpaces(100);
        parkingLot.setTotalSpaces(100);
        parkingLot.setOpeningHours("8:30-22:00");
        parkingLot.setHourlyPrice(2.3);
        parkingLot.setNotice("周末不营业");
        parkingLotDao.addParkingLot(parkingLot);

        //parkingLotDao.removeParkingLotById(1);
        parkingLotDao.queryForAll().forEach(x -> System.out.println(x));
        userDao.queryForAll().forEach(x -> System.out.print(x));
        // ApiImpl a = new ApiImpl(userDao);
        //testLogin(a, "bjut.edu", "123");
        //testReg(a, "bjut.edu", "123");
        connectionSource.close();
    }

    public static void testLogin(ApiImpl api, String name, String pass) throws SQLException {
        if (api.login(name, pass)) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    public static void testReg(ApiImpl api, String name, String pass) throws SQLException {
        if (api.register(name, pass)) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }
    }
}
