package smartparking.resources;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import smartparking.model.ParkingLot;

import java.util.List;

/**
 * 获取停车场,新建停车场,更新停车场的接口
 */

public interface ParkingLotsResource {
    @Get
    List<ParkingLot> getParkingLots();

    @Put
    int updateParkingLot(ParkingLot parkingLot);

    @Post
    int addParkingLot(ParkingLot parkingLot);
}
