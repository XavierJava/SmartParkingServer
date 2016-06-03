package smartparking.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.model.ParkingLot;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-19.
 */
public class ParkingLotDaoImpl extends BaseDaoImpl<ParkingLot, Integer> implements ParkingLotDao {
    public ParkingLotDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ParkingLot.class);
    }

    @Override
    public List getParkingLots() throws SQLException {
        return super.queryForAll();
    }

    @Override
    public ParkingLot getParkingLotById(int id) throws SQLException {
        return super.queryForId(id);
    }

    @Override
    public ParkingLot getParkingLotByName(String name) throws SQLException {
        return super.queryForEq("name", name).get(0);
    }

    @Override
    public GenericRawResults getNearbyParkingLots(double MyLongitude, double MyLatitude, int distance) throws IOException, SQLException {
        GenericRawResults<ParkingLot> rawResults =
                queryRaw("SELECT pklt.*,6371 * 2 * ASIN(SQRT(POWER(SIN((" +
                                MyLatitude + "-latitude) *pi()/180 / 2), 2) +COS(" + MyLatitude +
                                "* pi()/180) * COS(latitude * pi()/180) *POWER(SIN((" + MyLongitude +
                                "-longitude) * pi()/180 / 2), 2) )) as distance FROM t_parkingLots pklt WHERE longitude between " + MyLongitude + "-" + distance + "/abs(cos(radians(" + MyLatitude + "))*69) and " + MyLongitude + "+" + distance + "/abs(cos(radians(" + MyLatitude + "))*69)" +
                                "and latitude " +
                                "between " + MyLatitude + "-(" + distance + "/69) and " + MyLatitude + "+(" + distance + "/69) HAVING distance<" + distance + " order by distance",
                        new RawRowMapper<ParkingLot>() {
                            public ParkingLot mapRow(String[] columnNames,
                                                     String[] resultColumns) {
                                return new ParkingLot(Integer.parseInt(resultColumns[0]), resultColumns[1], resultColumns[2], Double.parseDouble(resultColumns[9]), Double.parseDouble(resultColumns[8]), Integer.parseInt(resultColumns[3]), Integer.parseInt(resultColumns[4]), Double.parseDouble(resultColumns[5]), resultColumns[6], resultColumns[7], Double.parseDouble(resultColumns[10]));
                            }
                        });
        return rawResults;
    }

    @Override
    public void addParkingLot(ParkingLot parkLot) throws SQLException {
        super.create(parkLot);
    }

    @Override
    public void editParkingLot(ParkingLot parkingLot) throws SQLException {
        super.update(parkingLot);
    }

    @Override
    public void removeParkingLotById(int id) throws SQLException {
        super.deleteById(id);
    }
}
