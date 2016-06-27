package smartparking.api;

import org.junit.Test;
import smartparking.api.impl.ParkingLotApiImpl;
import smartparking.model.ParkingLot;

public class ParkingLotApiTest {
    private ParkingLotApi parkingLotApi = new ParkingLotApiImpl();

    @Test
    public void testAddParkingLot() {
        ParkingLot parkingLot = new ParkingLot("工大", "北京市朝阳区平乐园100号", 39.9, 100.0, 60, 60, 4);
        assert parkingLotApi.getParkingLotById(parkingLotApi.addParkingLot(parkingLot)).equals("工大");
    }

    @Test
    public void testGetParkingLotByName() {
        ParkingLot parkingLot = new ParkingLot("北大", "北京市海淀区", 39.9, 100.0, 60, 60, 4);
        assert parkingLotApi.getParkingLotByName("北大") != null;
    }

    @Test
    public void testGetParkingLots() {
        ParkingLot parkingLot = new ParkingLot("南大", "北京市海淀区", 42.1, 104.0, 60, 60, 4);
        parkingLotApi.addParkingLot(parkingLot);
        parkingLotApi.addParkingLot(parkingLot);
        parkingLotApi.addParkingLot(parkingLot);
        int page = 1;
        int count = 2;
        assert parkingLotApi.getParkingLots(page, count).size() == count;
        count = 3;
        assert parkingLotApi.getParkingLots(page, count).size() == count;

    }

    @Test
    public void testGetNearbyParkingLots() {
        ParkingLot parkingLot = new ParkingLot("上大", "上海", 42.1, 66.0, 60, 60, 4);
        parkingLotApi.addParkingLot(parkingLot);
        parkingLotApi.addParkingLot(parkingLot);
        parkingLotApi.addParkingLot(parkingLot);
        assert parkingLotApi.getNearParkingLots(42.1, 66.0, 2).size() > 1;
    }

    @Test
    public void testUpdateParkingLot() {
        ParkingLot parkingLot = new ParkingLot("东大", "南京", 44.3, 66.0, 60, 60, 4);
        ParkingLot pk = parkingLotApi.getParkingLotById(parkingLotApi.addParkingLot(parkingLot));
        pk.setName("南大");
        parkingLotApi.updateParkingLot(pk);
        assert parkingLotApi.getParkingLotById(pk.getId()).getName().equals("南大");
    }

    @Test
    public void testRemoveParkingLotById() {
        ParkingLot parkingLot = new ParkingLot("山大", "济南", 55.4, 87.0, 60, 60, 4);
        assert parkingLotApi.removeParkingLotById(parkingLotApi.addParkingLot(parkingLot)) == 1;
    }
}
