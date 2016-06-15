package smartparking.server;

import com.j256.ormlite.dao.GenericRawResults;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.dao.ParkingLotDaoImpl;
import smartparking.dao.SingleConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-6-14.
 */
public class NearParkingLotsServerResource extends ServerResource implements smartparking.common.NearParkingLotsResource {
    String latitudeAttribute, longitudeAttribute, radiusAttribute;
    int radius;
    ParkingLotDaoImpl parkingLotDao;

    public NearParkingLotsServerResource() {
        try {
            parkingLotDao = new ParkingLotDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        latitudeAttribute = getAttribute("latitude");
        longitudeAttribute = getAttribute("longitude");
        radiusAttribute = getAttribute("radius");
        //setStatus(Status.CLIENT_ERROR_BAD_REQUEST, "请求错误");
    }

    @Get
    public Representation getNearParkingLots() {
        if (!checkAttributes(latitudeAttribute, longitudeAttribute, radiusAttribute))
            return new StringRepresentation("参数类型有误");
        GenericRawResults parkingLots = parkingLotDao.getNearParkingLots(Double.parseDouble(latitudeAttribute), Double.parseDouble(longitudeAttribute), Integer.parseInt(radiusAttribute));
        List results = null;
        try {
            results = parkingLots.getResults();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results != null && results.size() >= 1 ? new JacksonRepresentation<>(results) : new StringRepresentation("附近没有停车场");
    }

    public boolean checkAttributes(String latitude, String longitude, String radius) {
        return latitude.matches("^(-?\\d+)(\\.\\d+)?$") && longitude.matches("^(-?\\d+)(\\.\\d+)?$") && radius.matches("^[0-9]*[1-9][0-9]*$");
    }
}
