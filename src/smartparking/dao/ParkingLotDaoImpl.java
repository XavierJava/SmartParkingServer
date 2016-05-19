package smartparking.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.model.ParkingLot;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-19.
 */
public class ParkingLotDaoImpl extends BaseDaoImpl<ParkingLot, Integer> {
    public ParkingLotDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ParkingLot.class);
    }

    //return all parking lot
    public List getParkingLots() throws SQLException {
        return super.queryForAll();
    }

    public ParkingLot getParkingLotById(int id) throws SQLException {
        return super.queryForId(id);
    }

    //equal query
    public ParkingLot getParkingLotByName(String name) throws SQLException {
        return super.queryForEq("name", name).get(0);
    }

    public void addParkingLot(ParkingLot parkLot) throws SQLException {
        super.create(parkLot);
    }

    public void editParkingLot(ParkingLot parkingLot) throws SQLException {
        super.update(parkingLot);
    }

    public void removeParkingLotById(int id) throws SQLException {
        super.deleteById(id);
    }
}
