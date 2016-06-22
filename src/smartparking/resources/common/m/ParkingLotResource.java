package smartparking.resources.common.m;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import smartparking.model.ParkingLot;


public interface ParkingLotResource {
    @Get
    ParkingLot getParkingLot();

    @Delete
    int removeParkingLot();
}
