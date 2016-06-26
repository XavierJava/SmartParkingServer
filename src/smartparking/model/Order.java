package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import smartparking.dao.impl.OrderDaoImpl;

import java.util.Date;

@DatabaseTable(tableName = "t_orders", daoClass = OrderDaoImpl.class)
public class Order {
    @DatabaseField(generatedId = true, dataType = DataType.INTEGER)
    private int id;

    @DatabaseField(canBeNull = false, foreign = true, columnName = "id_lot")
    private ParkingLot parkingLot;

    @DatabaseField(canBeNull = false, foreign = true, columnName = "id_user")
    private User user;

    @DatabaseField(canBeNull = false, dataType = DataType.DATE_STRING, format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @DatabaseField(canBeNull = false, dataType = DataType.DOUBLE)
    private double amount;

    @DatabaseField(dataType = DataType.BOOLEAN)
    private boolean paid;

    public Order() {
        this.date = new Date();
        this.paid = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
