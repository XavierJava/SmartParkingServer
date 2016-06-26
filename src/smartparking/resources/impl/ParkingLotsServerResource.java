package smartparking.resources.impl;

import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.model.ParkingLot;
import smartparking.resources.ParkingLotsResource;

import java.util.List;

public class ParkingLotsServerResource extends ServerResource implements ParkingLotsResource {
    private ParkingLotDao parkingLotDao;
    /**
     * 页号
     */
    private String page;
    /**
     * 每页显示的项目数
     */
    private String count;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        page = getQueryValue("p");
        count = getQueryValue("c");
        parkingLotDao = Settings.getParkingLotDao();
    }

    @Override
    public List getParkingLots() {
        int page = 1;
        long limit = 10l;
        long offset = 1;
        if (this.page != null && this.page.matches("^[0-9]*[1-9][0-9]*$")) {
            page = Integer.parseInt(this.page);
        }

        if (this.count != null && this.count.matches("^[0-9]*[1-9][0-9]*$")) {
            limit = Long.parseLong(this.count);
        }
        offset = (page - 1) * limit + 1;
        return parkingLotDao.getParkingLots(offset, limit);
    }


    @Override
    public int updateParkingLot(ParkingLot parkingLot) {
        return parkingLotDao.updateParkingLot(parkingLot);
    }

    @Override
    public int addParkingLot(ParkingLot parkingLot) {

        return parkingLotDao.addParkingLot(parkingLot);
    }
}
