package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="userdetails")
public class User {
    @Id
   private String emailId;
   @Column(name="password")
   private String password;
   @Column(name="Name")
    private String name;
    @Column(name="PhoneNumber")
    private long phoneNo;
    @Column(name="Address")
    private String Address;
   
    public User() {
    }
    public User(String name, int phoneNo, String emailId, String password, String address) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.password = password;
        Address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
}
