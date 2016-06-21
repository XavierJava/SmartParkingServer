package smartparking.resources.parkingLots.impl;

import com.j256.ormlite.dao.GenericRawResults;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.resources.parkingLots.NearbyParkingLotsResource;

import java.io.IOException;
import java.sql.SQLException;
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

    @Get
    public Representation getNearParkingLots() {
        if (!checkAttributes(latitude, longitude, radius))
            return new StringRepresentation("参数类型有误");

        List results = null;

        try {
            GenericRawResults parkingLots = parkingLotDao.getNearParkingLots(Double.parseDouble(latitude), Double.parseDouble(longitude), Integer.parseInt(radius));
            results = parkingLots.getResults();
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }

        return results != null && results.size() >= 1 ? new JacksonRepresentation<>(results) : new StringRepresentation("附近没有停车场");
    }

    public boolean checkAttributes(String latitude, String longitude, String radius) {
        return latitude.matches("^(-?\\d+)(\\.\\d+)?$") && longitude.matches("^(-?\\d+)(\\.\\d+)?$") && radius.matches("^[0-9]*[1-9][0-9]*$");
    }
}
