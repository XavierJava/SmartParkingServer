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

    int addParkingLot(ParkingLot parkLot);

    int editParkingLot(ParkingLot parkingLot);

    int removeParkingLotById(int id);

    GenericRawResults getNearParkingLots(double longitude, double altitude, int kilometers) throws IOException, SQLException;

    List getParkingLots();

    ParkingLot getParkingLotById(int id);

    ParkingLot getParkingLotByName(String name);
}
