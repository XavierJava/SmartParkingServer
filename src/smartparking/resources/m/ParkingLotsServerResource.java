package smartparking.resources.m;

import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.model.ParkingLot;
import smartparking.resources.common.m.ParkingLotsResource;

public class ParkingLotsServerResource extends ServerResource implements ParkingLotsResource {
    private ParkingLotDao parkingLotDao;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();

        parkingLotDao = Settings.getParkingLotDao();
    }


    @Override
    public java.util.List getParkingLots() {

        return parkingLotDao.getParkingLots();
    }


    @Override
    public int updateParkingLot(ParkingLot parkingLot) {
        return parkingLotDao.editParkingLot(parkingLot);
    }

    @Override
    public int addParkingLot(ParkingLot parkingLot) {

        return parkingLotDao.addParkingLot(parkingLot);
    }
}
