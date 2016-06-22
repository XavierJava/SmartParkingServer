package smartparking.API;

import smartparking.model.ParkingLot;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ParkingLotApi {
    ParkingLot getParkingLotById(int id);

    ParkingLot getParkingLotByName(String name);

    List getParkingLots();

    List getNearParkingLots(double longitude, double altitude, int radius) throws IOException, SQLException;

    int addParkingLot(ParkingLot parkLot);

    int updateParkingLot(ParkingLot parkingLot);

    int removeParkingLotById(int id);
}
