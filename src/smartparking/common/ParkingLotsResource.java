package smartparking.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public interface ParkingLotsResource {
    @Get
    Representation getParkingLot() throws Exception;

    @Put
    void updateParkingLot(Representation rep) throws Exception;

    @Post
    void addParkingLot(Representation rep) throws Exception;

    @Delete
    void removeParkingLot(int parkingLotId) throws Exception;
}
