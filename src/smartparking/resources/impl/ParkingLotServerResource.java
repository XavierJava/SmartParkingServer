package smartparking.resources.impl;

import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.model.ParkingLot;
import smartparking.resources.ParkingLotResource;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ParkingLotServerResource extends ServerResource implements ParkingLotResource {
    private ParkingLotDao parkingLotDao;

    private String idOrName;
    private String q;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        parkingLotDao = Settings.getParkingLotDao();
        try {
            idOrName = URLDecoder.decode(getAttribute("idOrName"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        q = getQueryValue("q");
    }


    @Override
    public ParkingLot getParkingLot() {
        if (q.equals("id"))
            return parkingLotDao.getParkingLotById(Integer.parseInt(idOrName));
        if (q.equals("name"))
            return parkingLotDao.getParkingLotByName(idOrName);
        else
            return null;

    }

    @Override
    public int removeParkingLot() {
        return parkingLotDao.removeParkingLotById(Integer.parseInt(idOrName));
    }
}
