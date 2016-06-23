package smartparking.resources.impl;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.resources.common.NearbyParkingLotsResource;

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
    public Representation getNearParkingLots() {
        if (!checkAttributes(latitude, longitude, radius))
            return new StringRepresentation("参数类型有误");
        List results = parkingLotDao.getNearParkingLots(Double.parseDouble(latitude), Double.parseDouble(longitude), Integer.parseInt(radius));


        return results != null && results.size() >= 1 ? new JacksonRepresentation<>(results) : new StringRepresentation("附近没有停车场");
    }

    private boolean checkAttributes(String latitude, String longitude, String radius) {
        return latitude.matches("^(-?\\d+)(\\.\\d+)?$") && longitude.matches("^(-?\\d+)(\\.\\d+)?$") && radius.matches("^[0-9]*[1-9][0-9]*$");
    }
}
