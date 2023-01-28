package model;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class User {
    private int userid;
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private String password;
    private Date DOB;
    private String gender;

    public User() {
    }

    public User(String name, String emailAddress, String phoneNumber, String address, String password, Date DOB, String gender) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.DOB = DOB;
        this.gender = gender;
    }

    public User(int userid, String name, String emailAddress, String phoneNumber, String address, String password, Date DOB, String gender) {
        this.userid = userid;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.DOB = DOB;
        this.gender = gender;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
