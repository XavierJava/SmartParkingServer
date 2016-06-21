package smartparking.resources.parkingLots;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;

public interface ParkingLotResource {
    @Get
    Representation getParkingLot();

    @Delete
    String removeParkingLot();
}
