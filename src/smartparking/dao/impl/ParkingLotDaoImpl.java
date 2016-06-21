package smartparking.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.dao.ParkingLotDao;
import smartparking.model.ParkingLot;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotDaoImpl extends BaseDaoImpl<ParkingLot, Integer> implements ParkingLotDao {
    public ParkingLotDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ParkingLot.class);
    }

    @Override
    public List getParkingLots() {
        List list = new ArrayList<ParkingLot>();
        try {
            list = queryForAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public ParkingLot getParkingLotById(int id) {
        ParkingLot parkingLot = null;
        try {
            parkingLot = super.queryForId(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return parkingLot;
    }

    @Override
    public ParkingLot getParkingLotByName(String name) {
        ParkingLot parkingLot = null;
        try {
            parkingLot = queryForEq("name", name).get(0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return parkingLot;
    }

    @Override
    public GenericRawResults getNearParkingLots(double MyLatitude, double MyLongitude, int distance) {//乱码
        GenericRawResults<ParkingLot> rawResults = null;
        try {
            String sql = "SELECT pklt.*,6371 * 2 * ASIN(SQRT(POWER(SIN((" +
                    MyLatitude + "-latitude) *pi()/180 / 2), 2) +COS(" + MyLatitude +
                    "* pi()/180) * COS(latitude * pi()/180) *POWER(SIN((" + MyLongitude +
                    "-longitude) * pi()/180 / 2), 2) )) as distance FROM t_parkingLots pklt WHERE longitude between " + MyLongitude + "-" + distance + "/abs(cos(radians(" + MyLatitude + "))*69) and " + MyLongitude + "+" + distance + "/abs(cos(radians(" + MyLatitude + "))*69)" +
                    "and latitude " +
                    "between " + MyLatitude + "-(" + distance + "/69) and " + MyLatitude + "+(" + distance + "/69) HAVING distance<" + distance + " order by distance";
            //pklt.id,cast(pklt.name as char),cast(pklt.address as char),pklt.longitude,pklt.latitude,pklt.totalSpaces,pklt.availableSpaces,pklt.hourlyPrice,cast(pklt.openingHours as char),cast(pklt.notice as char)
            rawResults =
                    queryRaw(sql,
                            new RawRowMapper<ParkingLot>() {
                                public ParkingLot mapRow(String[] columnNames,
                                                         String[] resultColumns) {
                                    ParkingLot parkingLot = null;
                                    try {
                                        parkingLot = new ParkingLot(Integer.parseInt(resultColumns[0]), resultColumns[1], resultColumns[2], Double.parseDouble(resultColumns[3]), Double.parseDouble(resultColumns[4]), Integer.parseInt(resultColumns[5]), Integer.parseInt(resultColumns[6]), Double.parseDouble(resultColumns[7]), resultColumns[8], resultColumns[9], Double.parseDouble(resultColumns[10]));
                                        System.out.println("name:" + new String(resultColumns[1].getBytes("ISO8859-1"), "utf-8"));
                                        System.out.println("address:" + new String(resultColumns[2].getBytes("ISO8859-1"), "gbk"));
                                    } catch (UnsupportedEncodingException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    return parkingLot;
                                }
                            });
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rawResults;
    }

    @Override
    public int addParkingLot(ParkingLot parkLot) {
        int flag = 0;
        try {
            flag = create(parkLot);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @Override
    public int editParkingLot(ParkingLot parkingLot) {
        int flag = 0;
        try {
            flag = update(parkingLot);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @Override
    public int removeParkingLotById(int id) {
        int flag = 0;
        try {
            flag = deleteById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
