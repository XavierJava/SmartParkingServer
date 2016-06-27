package smartparking.resources.impl;

import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.model.ParkingLot;
import smartparking.resources.NearbyParkingLotsResource;

import java.util.List;

/**
 * 附近停车场的服务器资源
 */
public class NearbyParkingLotsServerResource extends ServerResource implements NearbyParkingLotsResource {
    private ParkingLotDao parkingLotDao;
    private String latitude, longitude, radius;

    /**
     * 初始化资源
     *
     * @throws ResourceException
     */
    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        /**
         * 获取URI中的参数
         */
        parkingLotDao = Settings.getParkingLotDao();
        latitude = getAttribute("latitude");
        longitude = getAttribute("longitude");
        radius = getAttribute("radius");
    }


    @Override
    public List<ParkingLot> getNearbyParkingLots() {
        return parkingLotDao.getNearParkingLots(Double.parseDouble(latitude), Double.parseDouble(longitude), Integer.parseInt(radius));

    }
}
