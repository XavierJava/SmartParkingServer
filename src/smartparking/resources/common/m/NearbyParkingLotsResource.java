package smartparking.resources.common.m;

import org.restlet.resource.Get;

import java.util.List;


public interface NearbyParkingLotsResource {
    @Get
    List getNearbyParkingLots();
}
