package smartparking;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.model.User;
import smartparking.service.UserService;
import smartparking.service.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Server {
    public static void main(String[] args) throws SQLException, IOException {
        System.out.println("Welcome to SmartParking Server.");

        String databaseUrl = "jdbc:mysql://localhost:3306/smartparking";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "***");

        UserService userService = new UserServiceImpl(connectionSource);

        userService.addUser(new User("name", "idCard", "plate", true));

        List<User> users = userService.getUsers();

        for(User user: users) {
            System.out.println(user);
        }

//        Dao<ParkingLot, Integer> parkingLotDao = DaoManager.createDao(connectionSource, ParkingLot.class);
//
//        TableUtils.createTableIfNotExists(connectionSource, ParkingLot.class);
//
//        ParkingLot parkingLot = new ParkingLot("北工大西门停车场", "西大望路", 100, 2);
//        parkingLotDao.create(parkingLot);
//
//        ParkingLot parkingLot2 = new ParkingLot("大望路停车场", "地铁大望路站", 200, 3);
//        parkingLotDao.create(parkingLot2);
//
//        List<ParkingLot> parkingLots = parkingLotDao.queryForAll();

        connectionSource.close();
    }
}
