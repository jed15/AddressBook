package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jeremydunsmore on 1/12/2017.
 */

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phone;
    private String address;




    public BuddyInfo() {
        this.name = "Default";
        this.phone = "000-000-0000";
        this.address = "";
    }

   public BuddyInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.address="";
    }

    public BuddyInfo(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address=address;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+", "+phone+", "+address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof BuddyInfo) {
           BuddyInfo buddy= (BuddyInfo) obj;
           return buddy.name.equals(this.name) && buddy.phone.equals(this.phone) && buddy.address.equals(this.address);
       }
       return false;
    }
}
