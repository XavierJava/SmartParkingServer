package smartparking.resources.common.m;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import smartparking.model.ParkingLot;


public interface ParkingLotsResource {
    @Get
    java.util.List getParkingLots();

    @Put
    int updateParkingLot(ParkingLot parkingLot);

    @Post
    int addParkingLot(ParkingLot parkingLot);
}
