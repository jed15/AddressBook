package com;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremydunsmore on 1/12/2017.
 */
@Entity
@Component
public class AddressBook {

    private List<BuddyInfo> buddies;


    private Integer id;
    public AddressBook() {
        this.buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy){
        this.buddies.add(buddy);
    }

    public String displayBuddies(){
        String s= new String();
        for(BuddyInfo buddy:buddies){
            s+=buddy.toString()+"\n";
        }
        return s;
    }

    public int numBuddies(){
        return buddies.size();
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<BuddyInfo> getBuddies(){
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies){
        this.buddies=buddies;
    }

    public void removeBuddy(BuddyInfo buddy){
        buddies.remove(buddy);
    }
    public static void main(String args[]){
        AddressBook book = new AddressBook();
        BuddyInfo peter= new BuddyInfo("Peter","123-456-7890");
        BuddyInfo blanch= new BuddyInfo("Cameron", "098-765-4321");
        BuddyInfo matt=  new BuddyInfo("Matt", "765-432-1890");

        book.addBuddy(peter);
        book.addBuddy(blanch);
        book.addBuddy(matt);

        System.out.println(book.displayBuddies());
    }

    @Id
    @GeneratedValue
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }
}
