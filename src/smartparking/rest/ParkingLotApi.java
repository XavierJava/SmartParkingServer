package smartparking.rest;

import smartparking.model.ParkingLot;

import java.util.List;

public interface ParkingLotApi {
    ParkingLot getParkingLotById(int id);

    ParkingLot getParkingLotByName(String name);

    List<ParkingLot> getParkingLots();

    List<ParkingLot> getNearParkingLots(double longitude, double altitude, int radius);

    int addParkingLot(ParkingLot parkLot);

    int updateParkingLot(ParkingLot parkingLot);

    int removeParkingLotById(int id);
}
