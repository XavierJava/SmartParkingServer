package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import smartparking.dao.impl.ParkingLotDaoImpl;

@DatabaseTable(tableName = "t_parkingLots", daoClass = ParkingLotDaoImpl.class)
public class ParkingLot {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String name;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String address;
    @DatabaseField(canBeNull = false)
    private double longitude;
    @DatabaseField(canBeNull = false)
    private double latitude;
    @DatabaseField(canBeNull = false)
    private int totalSpaces;
    @DatabaseField(canBeNull = false)
    private int availableSpaces;
    @DatabaseField(canBeNull = false)
    private double hourlyPrice;
    @DatabaseField(dataType = DataType.STRING_BYTES)
    private String openingHours;
    @DatabaseField(dataType = DataType.STRING_BYTES)
    private String notice;
    @DatabaseField(persisted = false)
    private double distance;

    public ParkingLot() {
    }

    public ParkingLot(String name, String address, double latitude, double longitude, int totalSpaces, int availableSpaces, double hourlyPrice) {
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.totalSpaces = totalSpaces;
        this.availableSpaces = availableSpaces;
        this.hourlyPrice = hourlyPrice;
    }

    public ParkingLot(int id, String name, String address, double longitude, double latitude, int totalSpaces, int availableSpaces, double hourlyPrice, String openingHours, String notice, double distance) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.totalSpaces = totalSpaces;
        this.availableSpaces = availableSpaces;
        this.hourlyPrice = hourlyPrice;
        this.openingHours = openingHours;
        this.notice = notice;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", totalSpaces=" + totalSpaces +
                ", availableSpaces=" + availableSpaces +
                ", hourlyPrice=" + hourlyPrice +
                ", openingHours='" + openingHours + '\'' +
                ", notice='" + notice + '\'' +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingLot that = (ParkingLot) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
