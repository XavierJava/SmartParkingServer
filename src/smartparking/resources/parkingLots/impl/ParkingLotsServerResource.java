package smartparking.resources.parkingLots.impl;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.SingleConnectionSource;
import smartparking.dao.impl.ParkingLotDaoImpl;
import smartparking.model.ParkingLot;
import smartparking.resources.parkingLots.ParkingLotsResource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public class ParkingLotsServerResource extends ServerResource implements ParkingLotsResource {
    ParkingLotDaoImpl parkingLotDao;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        System.out.println(getLocationRef());
        System.out.println(getOriginalRef().getPath());
        try {
            parkingLotDao = new ParkingLotDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Representation getParkingLots() {
        List parkingLots = parkingLotDao.getParkingLots();
        return parkingLots != null ? new JacksonRepresentation<>(parkingLots) : new StringRepresentation("没有停车场");
    }

    @Override
    public String updateParkingLot(Representation rep) {
        JacksonRepresentation<ParkingLot> parkingLotRep = new JacksonRepresentation<ParkingLot>(
                rep, ParkingLot.class);
        ParkingLot parkingLot = null;
        try {
            parkingLot = parkingLotRep.getObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return parkingLotDao.editParkingLot(parkingLot) > 0 ? "修改成功" : "修改失败";
    }

    @Override
    public String addParkingLot(Representation rep) {
        JacksonRepresentation<ParkingLot> parkingLotRep = new JacksonRepresentation<ParkingLot>(
                rep, ParkingLot.class);
        ParkingLot parkingLot = null;
        try {
            parkingLot = parkingLotRep.getObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return parkingLotDao.addParkingLot(parkingLot) > 0 ? "新增成功" : "新增失败";
    }
}
