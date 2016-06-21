package smartparking.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public interface ParkingLotResource {
    @Get
    Representation getParkingLot();

    @Delete
    String removeParkingLot();
}