package smartparking.dao;

import com.j256.ormlite.dao.GenericRawResults;
import smartparking.model.ParkingLot;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-20.
 */
public interface ParkingLotDao {

    void addParkingLot(ParkingLot parkLot) throws SQLException;

    void editParkingLot(ParkingLot parkingLot) throws SQLException;

    void removeParkingLotById(int id) throws SQLException;

    GenericRawResults getNearbyParkingLots(double longitude, double altitude, int kilometers) throws IOException, SQLException;

    List getParkingLots() throws SQLException;

    ParkingLot getParkingLotById(int id) throws SQLException;

    ParkingLot getParkingLotByName(String name) throws SQLException;
}
