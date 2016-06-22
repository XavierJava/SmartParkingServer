package smartparking.resources.impl;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.model.ParkingLot;
import smartparking.resources.common.ParkingLotResource;

public class ParkingLotServerResource extends ServerResource implements ParkingLotResource {
    private ParkingLotDao parkingLotDao;

    private String parkingLotId;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();

        parkingLotDao = Settings.getParkingLotDao();

        parkingLotId = getAttribute("parkingLotId");

        System.out.println("停车场id:" + parkingLotId);
    }

    @Override
    public Representation getParkingLot() {
        if (parkingLotId == null || !parkingLotId.matches("^[0-9]*[1-9][0-9]*$"))
            return new StringRepresentation("参数类型错误");

        ParkingLot parkingLot = parkingLotDao.getParkingLotById(Integer.parseInt(parkingLotId));

        return parkingLot != null ? new JacksonRepresentation<>(parkingLot) : new StringRepresentation("没有该停车场");
    }

    @Override
    public String removeParkingLot() {
        if (parkingLotId == null || !parkingLotId.matches("^[0-9]*[1-9][0-9]*$"))
            return "参数类型错误";

        return parkingLotDao.removeParkingLotById(Integer.parseInt(parkingLotId)) > 0 ? "删除成功" : "删除失败";
    }
}
