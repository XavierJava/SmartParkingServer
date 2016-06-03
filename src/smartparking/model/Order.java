package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import smartparking.dao.OrderDaoImpl;

import java.util.Date;

@DatabaseTable(tableName = "t_orders", daoClass = OrderDaoImpl.class)
public class Order {
    //order's id
    @DatabaseField(generatedId = true)
    private int id;
    //parking lot's id
    @DatabaseField(canBeNull = false, foreign = true, columnName = "id_lot")
    private ParkingLot parkingLot;
    //user's id
    @DatabaseField(canBeNull = false, foreign = true, columnName = "id_user")
    private User user;
    //when it be generated,specified by constructor!
    @DatabaseField(canBeNull = false, dataType = DataType.DATE_STRING)
    private Date date;
    //amount of the order
    @DatabaseField(canBeNull = false)
    private double amount;
    @DatabaseField
    private boolean payed;

    public Order() {
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", parkingLot=" + parkingLot +
                ", user=" + user +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
