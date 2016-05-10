package smartparking;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import smartparking.model.ParkingLot;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Server {
    public static void main(String[] args) throws SQLException, IOException {
        System.out.println("Welcome to SmartParking Server.");

        String databaseUrl = "jdbc:mysql://localhost:3306/smartparking";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "1026@ustc");

        Dao<ParkingLot, Integer> parkingLotDao = DaoManager.createDao(connectionSource, ParkingLot.class);

        TableUtils.createTableIfNotExists(connectionSource, ParkingLot.class);

        ParkingLot parkingLot = new ParkingLot("北工大西门停车场", "西大望路", 100, 2);
        parkingLotDao.create(parkingLot);

        ParkingLot parkingLot2 = new ParkingLot("大望路停车场", "地铁大望路站", 200, 3);
        parkingLotDao.create(parkingLot2);

        List<ParkingLot> parkingLots = parkingLotDao.queryForAll();

        connectionSource.close();
    }
}
