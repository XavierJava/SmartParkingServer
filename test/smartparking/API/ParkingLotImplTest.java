package smartparking.API;

import org.junit.Test;
import smartparking.API.m.ParkingLotImpl;
import smartparking.model.ParkingLot;

public class ParkingLotImplTest {
    private ParkingLotImpl parkingLotImpl = new ParkingLotImpl();
    private ParkingLot parkingLot = new ParkingLot("beijing", "北京市朝阳区平乐园100号", 39.9, 100.0, 60, 60, 4);

    @Test
    public void testAddParkingLot() {
        assert parkingLotImpl.addParkingLot(parkingLot) > 0;
    }

    @Test
    public void testGetParkingLotById() {
        assert parkingLotImpl.getParkingLotById(3) != null;
    }

    @Test
    public void testGetParkingLotByName() {
        assert parkingLotImpl.getParkingLotByName("beijing") != null;
    }

    @Test
    public void testGetParkingLots() {
        assert parkingLotImpl.getParkingLots().size() > 1;
    }

    @Test
    public void testGetNearbyParkingLots() {
        assert parkingLotImpl.getNearParkingLots(39.9, 100, 2).size() > 0;
    }

    @Test
    public void testUpdateParkingLot() {
        ParkingLot parkingLot = parkingLotImpl.getParkingLotById(8);
        parkingLot.setAddress("北京市朝阳区朝阳公园");
        assert parkingLotImpl.updateParkingLot(parkingLot) > 0;
    }

    @Test
    public void testRemoveParkingLotById() {
        assert parkingLotImpl.removeParkingLotById(5) > 0;
    }
}
