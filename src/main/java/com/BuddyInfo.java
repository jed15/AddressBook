package com;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jeremydunsmore on 1/12/2017.
 */

@Entity
public class BuddyInfo {

    @Id
    private String name;
    private String phone;




    public BuddyInfo(){
        this.name="Default";
        this.phone="000-000-0000";
    }

   public BuddyInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
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
        return name+", "+phone;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof BuddyInfo) {
           BuddyInfo buddy= (BuddyInfo) obj;
           return buddy.name.equals(this.name) && buddy.phone.equals(this.phone);
       }
       return false;
    }
}
