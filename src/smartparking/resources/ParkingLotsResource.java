package smartparking.resources;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import smartparking.model.ParkingLot;

import java.util.List;


public interface ParkingLotsResource {
    @Get
    List<ParkingLot> getParkingLots();

    @Put
    int updateParkingLot(ParkingLot parkingLot);

    @Post
    int addParkingLot(ParkingLot parkingLot);
}
