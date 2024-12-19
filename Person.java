package Practice_Interface;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String firstName;
    private String surName;
    private Date birthday;
    private boolean gender;
    private String phone;

    public Person(){
        id = "";
        firstName = "";
        surName = "";
        birthday =  new Date();
        gender = false;
        phone = "";
    }

    public Person(String id, String firstName, String surName, Date birthday, boolean gender, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return surName;
    }

    public void setSureName(String surName) {
        this.surName = surName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formatDate = sdf.format(birthday);
        return String.format("%-25s %-23s %-23s %-33s %-23s %-24s",
                id, surName, firstName, formatDate, (gender ? "Male" : "Female"), phone);
    }



}
