package smartparking.server;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.ParkingLotsResource;
import smartparking.dao.ParkingLotDaoImpl;
import smartparking.dao.SingleConnectionSource;
import smartparking.model.ParkingLot;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public class ParkingLotsServerResource extends ServerResource implements ParkingLotsResource {
    int parkingLotId;
    ParkingLotDaoImpl parkingLotDao;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        System.out.println(getLocationRef());
        String parkingLotIdAttribute = getAttribute("parkingLotId");
        System.out.println("停车场id:" + parkingLotIdAttribute);
        try {
            parkingLotDao = new ParkingLotDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (parkingLotIdAttribute != null) {
            this.parkingLotId = Integer.parseInt(parkingLotIdAttribute);
            setName("Resource for parking account '" + this.parkingLotId + "'");
            setDescription("The resource describing the parking account number '"
                    + this.parkingLotId + "'");
        } else {
            setName("parking account resource");
            setDescription("The resource describing a parking account");
        }
    }

    @Override
    public Representation getParkingLot() throws SQLException {

        ParkingLot parkingLot = parkingLotDao.getParkingLotById(parkingLotId);
        return new JacksonRepresentation<ParkingLot>(parkingLot);
    }

    @Override
    public void updateParkingLot(Representation rep) throws SQLException, IOException {
        JacksonRepresentation<ParkingLot> parkingLotRep = new JacksonRepresentation<ParkingLot>(
                rep, ParkingLot.class);
        ParkingLot parkingLot = (ParkingLot) parkingLotRep.getObject();
        parkingLotDao.editParkingLot(parkingLot);
    }

    @Override
    public void addParkingLot(Representation rep) throws SQLException, IOException {
        JacksonRepresentation<ParkingLot> parkingLotRep = new JacksonRepresentation<ParkingLot>(
                rep, ParkingLot.class);
        ParkingLot parkingLot = (ParkingLot) parkingLotRep.getObject();
        parkingLotDao.addParkingLot(parkingLot);
    }

    @Override
    public void removeParkingLot(int parkingLotId) throws SQLException {
        parkingLotDao.removeParkingLotById(parkingLotId);
    }
}
