package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class User {
    @DatabaseField(generatedId=true)
    private int id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String name;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String idCard;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String plateNumber;

    @DatabaseField(canBeNull = false)
    private Boolean gender;

    @DatabaseField(canBeNull = false, dataType = DataType.DATE_STRING)
    private Date date;

    User() {
    }

    public User(String name, String idCard, String plateNumber, Boolean gender) {
        this.name = name;
        this.idCard = idCard;
        this.plateNumber = plateNumber;
        this.gender = gender;

        this.date = new Date();
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', idCard='%s', plateNumber='%s', gender=%s, date=%s}", id, name, idCard, plateNumber, gender, date);
    }
}
