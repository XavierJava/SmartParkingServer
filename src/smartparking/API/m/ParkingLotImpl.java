package smartparking.API.m;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import smartparking.API.ParkingLotApi;
import smartparking.model.ParkingLot;
import smartparking.resources.common.m.NearbyParkingLotsResource;
import smartparking.resources.common.m.ParkingLotResource;
import smartparking.resources.common.m.ParkingLotsResource;

import java.util.List;

public class ParkingLotImpl implements ParkingLotApi {
    private Client client = new Client(new Context(), Protocol.HTTP);
    private ClientResource service = new ClientResource("http://localhost:8111");

    @Override
    public ParkingLot getParkingLotById(int id) {
        ParkingLotResource parkingLotResource = service.getChild("/parking_lot/" + id + "?q=id", ParkingLotResource.class);
        return parkingLotResource.getParkingLot();
    }

    @Override
    public ParkingLot getParkingLotByName(String name) {
        ParkingLotResource parkingLotResource = service.getChild("/parking_lot/" + name + "?q=name", ParkingLotResource.class);
        return parkingLotResource.getParkingLot();
    }

    @Override
    public List getParkingLots() {
        ParkingLotsResource parkingLotsResource = service.getChild("/parking_lots", ParkingLotsResource.class);
        return parkingLotsResource.getParkingLots();
    }

    @Override
    public List getNearParkingLots(double latitude, double longitude, int radius) {
        NearbyParkingLotsResource nearbyParkingLotsServerResource = service.getChild("/nearby_parking_lots/" + latitude + "/" + longitude + "/" + radius, NearbyParkingLotsResource.class);
        return nearbyParkingLotsServerResource.getNearbyParkingLots();
    }

    @Override
    public int addParkingLot(ParkingLot parkingLot) {
        ParkingLotsResource parkingLotsResource = service.getChild("/parking_lots", ParkingLotsResource.class);
        return parkingLotsResource.addParkingLot(parkingLot);
    }

    public int updateParkingLot(ParkingLot parkingLot) {
        ParkingLotsResource parkingLotsResource = service.getChild("/parking_lots", ParkingLotsResource.class);
        return parkingLotsResource.updateParkingLot(parkingLot);
    }

    @Override
    public int removeParkingLotById(int id) {
        ParkingLotResource parkingLotResource = service.getChild("/parking_lot/" + id, ParkingLotResource.class);
        return parkingLotResource.removeParkingLot();
    }
}
