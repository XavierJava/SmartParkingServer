package smartparking.resources.parkingLots.impl;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.model.ParkingLot;
import smartparking.resources.parkingLots.ParkingLotsResource;

import java.io.IOException;
import java.util.List;

public class ParkingLotsServerResource extends ServerResource implements ParkingLotsResource {
    private ParkingLotDao parkingLotDao;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();

        parkingLotDao = Settings.getParkingLotDao();
    }

    @Override
    public Representation getParkingLots() {
        List parkingLots = parkingLotDao.getParkingLots();

        return parkingLots != null ? new JacksonRepresentation<>(parkingLots) : new StringRepresentation("没有停车场");
    }

    @Override
    public String updateParkingLot(Representation rep) {
        JacksonRepresentation<ParkingLot> parkingLotRep = new JacksonRepresentation<>(
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
        JacksonRepresentation<ParkingLot> parkingLotRep = new JacksonRepresentation<>(
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
