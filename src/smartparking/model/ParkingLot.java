package smartparking.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ParkingLot {
    @DatabaseField(id = true)
    private int id;

    private String name;
    private String address;
    private int numPlaces;
    private double hourlyPrice;

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
