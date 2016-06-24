package smartparking.resources.impl;

import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.resources.NearbyParkingLotsResource;

import java.util.List;

public class NearbyParkingLotsServerResource extends ServerResource implements NearbyParkingLotsResource {
    private ParkingLotDao parkingLotDao;

    private String latitude, longitude, radius;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();

        parkingLotDao = Settings.getParkingLotDao();

        latitude = getAttribute("latitude");
        longitude = getAttribute("longitude");
        radius = getAttribute("radius");
    }


    @Override
    public List getNearbyParkingLots() {
        return parkingLotDao.getNearParkingLots(Double.parseDouble(latitude), Double.parseDouble(longitude), Integer.parseInt(radius));

    }
}
