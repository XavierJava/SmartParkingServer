package smartparking.resources;

import org.restlet.resource.Get;
import smartparking.model.ParkingLot;

import java.util.List;

/**
 * 获取附近停车场的接口
 */

public interface NearbyParkingLotsResource {
    @Get
    List<ParkingLot> getNearbyParkingLots();
}
