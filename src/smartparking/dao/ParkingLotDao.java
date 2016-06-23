package smartparking.dao;

import smartparking.model.ParkingLot;

import java.util.List;

public interface ParkingLotDao {
    ParkingLot getParkingLotById(int id);

    ParkingLot getParkingLotByName(String name);

    List<ParkingLot> getParkingLots();

    List<ParkingLot> getNearParkingLots(double longitude, double latitude, int kilometers);

    int addParkingLot(ParkingLot parkLot);

    int updateParkingLot(ParkingLot parkingLot);

    int removeParkingLotById(int id);

}
