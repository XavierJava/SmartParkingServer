package smartparking.model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class Order {
    @DatabaseField(generatedId=true)
    private int id;

    @DatabaseField(canBeNull = false)
    private Date date;

    @DatabaseField(canBeNull = false)
    private ParkingLot parkingLot;

    @DatabaseField(canBeNull = false)
    private User user;

}
