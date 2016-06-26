package smartparking.api;

import smartparking.model.ParkingLot;

import java.util.List;

public interface ParkingLotApi {
    ParkingLot getParkingLotById(int id);

    ParkingLot getParkingLotByName(String name);

    List<ParkingLot> getParkingLots(int page, int count);

    List<ParkingLot> getNearParkingLots(double longitude, double altitude, int radius);

    int addParkingLot(ParkingLot parkLot);

    int updateParkingLot(ParkingLot parkingLot);

    int removeParkingLotById(int id);
}
