package com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jeremydunsmore on 1/26/2017.
 */
public class RefreshListener implements ActionListener {
    private AddressBook book;
    private JList<String> list;

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<String> buddies = new DefaultListModel<String>();
        for(BuddyInfo b : book.getBuddies()){
            buddies.addElement(b.toString());
        }
        list.setModel(buddies);
    }

    public AddressBook getBook() {
        return book;
    }

    public void setBook(AddressBook book) {
        this.book = book;
    }

    public JList<String> getBuddies() {
        return list;
    }

    public void setList(JList<String> list) {
        this.list = list;
    }

}
