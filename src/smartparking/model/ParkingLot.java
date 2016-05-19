package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import smartparking.dao.ParkingLotDaoImpl;

@DatabaseTable(tableName = "t_parkingLots", daoClass = ParkingLotDaoImpl.class)
public class ParkingLot {
    //ID auto created
    @DatabaseField(generatedId = true)
    private int id;
    //lot's name
    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String name;
    //lot's address
    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String address;
    //total parking spaces
    @DatabaseField(canBeNull = false)
    private int totalSpaces;
    //number of available parking spaces
    @DatabaseField(canBeNull = false)
    private int availableSpaces;
    //Price
    @DatabaseField(canBeNull = false)
    private double hourlyPrice;
    //opening hours,from hour to hour daily
    @DatabaseField(canBeNull = true, dataType = DataType.STRING_BYTES)
    private String openingHours;
    //something important,eg..whether open at weekends
    @DatabaseField(canBeNull = true, dataType = DataType.STRING_BYTES)
    private String notice;

    public ParkingLot() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", totalSpaces=" + totalSpaces +
                ", availableSpaces=" + availableSpaces +
                ", hourlyPrice=" + hourlyPrice +
                ", openingHours='" + openingHours + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }
}
