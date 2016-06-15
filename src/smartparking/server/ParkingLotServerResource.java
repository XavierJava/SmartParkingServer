package smartparking.server;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.ParkingLotResource;
import smartparking.dao.ParkingLotDaoImpl;
import smartparking.dao.SingleConnectionSource;
import smartparking.model.ParkingLot;

import java.sql.SQLException;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public class ParkingLotServerResource extends ServerResource implements ParkingLotResource {
    ParkingLotDaoImpl parkingLotDao;
    String parkingLotIdAttribute;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        System.out.println(getLocationRef());
        parkingLotIdAttribute = getAttribute("parkingLotId");
        System.out.println("停车场id:" + parkingLotIdAttribute);
        try {
            parkingLotDao = new ParkingLotDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Representation getParkingLot() {
        if (parkingLotIdAttribute == null || !parkingLotIdAttribute.matches("^[0-9]*[1-9][0-9]*$"))
            return new StringRepresentation("参数类型错误");
        ParkingLot parkingLot = parkingLotDao.getParkingLotById(Integer.parseInt(parkingLotIdAttribute));
        return parkingLot != null ? new JacksonRepresentation<>(parkingLot) : new StringRepresentation("没有该停车场");
    }

    @Override
    public String removeParkingLot() {
        if (parkingLotIdAttribute == null || !parkingLotIdAttribute.matches("^[0-9]*[1-9][0-9]*$"))
            return "参数类型错误";
        return parkingLotDao.removeParkingLotById(Integer.parseInt(parkingLotIdAttribute)) > 0 ? "删除成功" : "删除失败";
    }
}
