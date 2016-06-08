package smartparking.client;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.api.ApiImpl;
import smartparking.dao.OrderDaoImpl;
import smartparking.dao.ParkingLotDaoImpl;
import smartparking.dao.UserDaoImpl;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by chenhuanhuan on 16-5-20.
 */
public class ApiTest {
    public static void main(String[] args) throws SQLException, IOException {
        String databaseUrl = "jdbc:mysql://localhost:3306/smartparking";
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "chenhuan");
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(connectionSource);
        UserDaoImpl userDao = new UserDaoImpl(connectionSource);
        OrderDaoImpl orderDao = new OrderDaoImpl(connectionSource);
        //TableUtils.createTableIfNotExists(connectionSource, Order.class);
        //TableUtils.createTableIfNotExists(connectionSource, ParkingLot.class);
        // TableUtils.createTableIfNotExists(connectionSource, Order.class);
        /*ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("北工大南门停车场");
        parkingLot.setAddress("北京北京市平乐园100号");
        parkingLot.setLatitude(39.9999);
        parkingLot.setLongitude(1164867);
        parkingLot.setAvailableSpaces(100);
        parkingLot.setTotalSpaces(100);
        parkingLot.setOpeningHours("8:30-22:00");
        parkingLot.setHourlyPrice(2.3);
        parkingLot.setNotice("周末不营业");
        parkingLotDao.addParkingLot(parkingLot);
        parkingLotDao.queryForAll().forEach(x -> System.out.println(x));*/
        //userDao.queryForAll().forEach(x->System.out.println(x));
        //parkingLotDao.queryForAll().forEach(x -> System.out.println(x));
        ApiImpl a = new ApiImpl(userDao);
        testLogin(a, "huanlove", "chh912");
        // testReg(a, "bjut.edu.cn", "1234");
        //connectionSource.close();
       /* String MyLatitude="39.9899";
        String MyLongitude="116.4867";
        int distance=2;
        System.out.println("SELECT pklt.id,6371 * 2 * ASIN(SQRT(POWER(SIN(("+
                MyLatitude+"-latitude) *pi()/180 / 2), 2) +COS("+MyLatitude+
                "* pi()/180) * COS(latitude * pi()/180) *POWER(SIN(("+MyLongitude+
                "-longitude) * pi()/180 / 2), 2) )) as distance FROM t_parkingLots pklt WHERE longitude between "+MyLongitude+"-"+distance+"/abs(cos(radians("+MyLatitude+"))*69) and "+MyLongitude+"+"+distance+"/abs(cos(radians("+MyLatitude+"))*69)" +
                "and latitude " +
                "between "+MyLatitude+"-("+distance+"/69) and "+MyLatitude+"+("+distance+"/69) HAVING distance<"+distance+" order by distance");*/
        /*GenericRawResults<ParkingLot> rawResults = parkingLotDao.getNearbyParkingLots(116.4867, 39.9877, 2);
        if (rawResults.getNumberColumns() > 0)
            for (ParkingLot p : rawResults) {
                System.out.println(p);
            }
        rawResults.close();*/
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
