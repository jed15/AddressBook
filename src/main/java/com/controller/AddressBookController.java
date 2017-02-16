package com.controller;

import com.AddressBook;
import com.AddressBookRepository;
import com.BuddyInfo;
import com.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeremydunsmore on 2/16/2017.
 */

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressRepo;
    @Autowired
    private BuddyInfoRepository buddyRepo;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<AddressBook> books = addressRepo.findAll();
        model.addAttribute("newBook", new AddressBook());
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/book")
    public String viewBook(@RequestParam("id") Integer id, Model model) {
        AddressBook book = addressRepo.findOne(id);
        model.addAttribute("book", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "book";
    }

    @PostMapping("/book")
    public String viewBook(@ModelAttribute("newBook") AddressBook book, Model model) {
        addressRepo.save(book);
        model.addAttribute("book", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "book";
    }

    @PostMapping("/buddy/create")
    public String createBuddy(@ModelAttribute("newBuddy") BuddyInfo buddy, @RequestParam("bookId") Integer bookId, Model model) {
        AddressBook book = addressRepo.findOne(bookId);
        book.addBuddy(buddy);
        addressRepo.save(book);
        model.addAttribute("newBuddy", new BuddyInfo());
        model.addAttribute("book", book);
        return "book";
    }
}
