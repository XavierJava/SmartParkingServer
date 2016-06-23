package smartparking.resources.common.m;

import org.restlet.resource.Get;
import smartparking.model.ParkingLot;

import java.util.List;


public interface NearbyParkingLotsResource {
    @Get
    List<ParkingLot> getNearbyParkingLots();
}
