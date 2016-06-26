package smartparking.api;

import org.junit.Test;
import smartparking.api.impl.ParkingLotApiImpl;
import smartparking.model.ParkingLot;

public class ParkingLotApiTest {
    private ParkingLotApi parkingLotApi = new ParkingLotApiImpl();
    private ParkingLot parkingLot = new ParkingLot("工大", "北京市朝阳区平乐园100号", 39.9, 100.0, 60, 60, 4);


    @Test
    public void testAddParkingLot() {
        assert parkingLotApi.addParkingLot(parkingLot) > 0;
    }

    @Test
    public void testGetParkingLotById() {
        assert parkingLotApi.getParkingLotById(1) != null;
    }

    @Test
    public void testGetParkingLotByName() {
        assert parkingLotApi.getParkingLotByName("工大") != null;
    }

    @Test
    public void testGetParkingLots() {
        int page = 1;
        int count = 2;
        assert parkingLotApi.getParkingLots(page, count).size() > 1;
    }

    @Test
    public void testGetNearbyParkingLots() {
        assert parkingLotApi.getNearParkingLots(39.9, 100, 2).size() > 0;
    }

    @Test
    public void testUpdateParkingLot() {
        ParkingLot parkingLot = parkingLotApi.getParkingLotById(8);
        parkingLot.setAddress("北京市朝阳区朝阳公园");
        assert parkingLotApi.updateParkingLot(parkingLot) > 0;
    }

    @Test
    public void testRemoveParkingLotById() {
        assert parkingLotApi.removeParkingLotById(5) > 0;
    }
}
