package smartparking.resources.parkingLots;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;


/**
 * 停车场资源.
 */
public interface ParkingLotsResource {
    /**
     * 获取停车场列表.
     *
     * @return 停车场列表
     */
    @Get
    Representation getParkingLots();

    /**
     * 添加停车场.
     *
     * @param rep 停车场
     * @return 添加操作的执行结果
     */
    @Post
    String addParkingLot(Representation rep);

    /**
     * 更新指定的停车场.
     *
     * @param rep 停车场
     * @return 更新操作的执行结果
     */
    @Put
    String updateParkingLot(Representation rep);

}
