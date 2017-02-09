package com.controller;

import com.AddressBook;
import com.AddressBookRepository;
import com.BuddyInfo;
import com.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeremydunsmore on 2/2/2017.
 */
@RestController
public class AddressBookController {


    @Autowired
    private AddressBookRepository addressRepo;

    @Autowired
    private BuddyInfoRepository buddyRepo;

    @RequestMapping("/add")
    public AddressBook addBuddy (@RequestParam("bookid") Integer bookid,@RequestParam("name") String name , @RequestParam("phone") String phone){
        AddressBook book = getOrCreateAddressBook(bookid);
        book.addBuddy(new BuddyInfo(name,phone));
        addressRepo.save(book);
        return book;

    }

    private AddressBook getOrCreateAddressBook(@RequestParam("bookid") Integer bookid) {
        AddressBook book=addressRepo.findOne(bookid);
        if(book == null){
            book = new AddressBook();
        }
        return book;
    }

    @RequestMapping("/get")
    public AddressBook getBook(@RequestParam("id") Integer id){
        AddressBook book=addressRepo.findOne(id);
        return book;
    }

    @RequestMapping("/remove")
    public AddressBook removeBuddy(@RequestParam("bookid") Integer bookid,@RequestParam("name") String name, @RequestParam("phone") String phone){
        AddressBook book = getOrCreateAddressBook(bookid);
        book.removeBuddy(new BuddyInfo(name,phone));
        addressRepo.save(book);
        buddyRepo.delete(name);
        return book;
    }

}
