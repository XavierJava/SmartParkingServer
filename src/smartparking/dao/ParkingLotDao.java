package smartparking.dao;

import smartparking.model.ParkingLot;

import java.util.List;

public interface ParkingLotDao {

    int addParkingLot(ParkingLot parkLot);

    int editParkingLot(ParkingLot parkingLot);

    int removeParkingLotById(int id);

    List getNearParkingLots(double longitude, double latitude, int kilometers);

    List getParkingLots();

    ParkingLot getParkingLotById(int id);

    ParkingLot getParkingLotByName(String name);
}
