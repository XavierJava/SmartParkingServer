package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class ParkingLot {
    @DatabaseField(generatedId=true)
    private int id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String name;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String address;

    @DatabaseField(canBeNull = false)
    private int numPlaces;

    @DatabaseField(canBeNull = false)
    private double hourlyPrice;

    @DatabaseField(canBeNull = false)
    private Date date;

    public ParkingLot() {
    }

    public ParkingLot(String name, String address, int numPlaces, double hourlyPrice) {
        this.name = name;
        this.address = address;
        this.numPlaces = numPlaces;
        this.hourlyPrice = hourlyPrice;
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

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }
}
