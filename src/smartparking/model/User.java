package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import smartparking.dao.impl.UserDaoImpl;

import java.util.Date;

@DatabaseTable(tableName = "t_users", daoClass = UserDaoImpl.class)
public class User {
    //ID auto created
    @DatabaseField(generatedId = true)
    private int id;
    //username unique in database;be careful with mess code.x
    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES)
    private String name;
    //user's password
    @DatabaseField(canBeNull = false, dataType = DataType.STRING_BYTES, columnName = "pswd")
    private String password;
    //identity number
    @DatabaseField(canBeNull = true, unique = true, index = true)
    private String idNo;
    //car's plate
    @DatabaseField(canBeNull = true, dataType = DataType.STRING_BYTES)
    private String plateNumber;
    //gender
    @DatabaseField(canBeNull = true)
    private Boolean gender;
    //register date,specified by Database!
    @DatabaseField(canBeNull = true, dataType = DataType.DATE_STRING)
    private Date regDate;
    //e mail address
    @DatabaseField(canBeNull = true, index = true)
    private String email;
    //telephone number
    @DatabaseField(canBeNull = true, index = true)
    private String phone;
    //activation code,1:telephone;2:email ;whether activated,>0:activated
    @DatabaseField(canBeNull = true)
    private int howActivate;
    //VIP Database specify it=0 by default
    @DatabaseField(canBeNull = true)
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
}
