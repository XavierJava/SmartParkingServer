package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import smartparking.dao.impl.UserDaoImpl;

import java.util.Date;

/**
 * 用户类
 */

@DatabaseTable(tableName = "t_users", daoClass = UserDaoImpl.class)
public class User {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String name;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES, columnName = "pswd")
    private String password;
    @DatabaseField(unique = true, index = true)
    private String idNo;
    @DatabaseField(dataType = DataType.STRING_BYTES)
    private String plateNumber;
    @DatabaseField
    private Boolean gender;
    @DatabaseField(dataType = DataType.DATE_STRING)
    private Date regDate;
    @DatabaseField(index = true)
    private String email;
    @DatabaseField(index = true)
    private String phone;
    @DatabaseField
    private int howActivate;
    @DatabaseField
    private int IPLevel;

    public User() {
        this.regDate = new Date();
        this.IPLevel = 0;
        this.howActivate = 0;
        this.email = "";
        this.phone = "";
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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getHowActivate() {
        return howActivate;
    }

    public void setHowActivate(int howActivate) {
        this.howActivate = howActivate;
    }

    public int getIPLevel() {
        return IPLevel;
    }

    public void setIPLevel(int IPLevel) {
        this.IPLevel = IPLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", idNo='" + idNo + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", gender=" + gender +
                ", regDate=" + regDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", howActivate=" + howActivate +
                ", IPLevel=" + IPLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
