package com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jeremydunsmore on 1/26/2017.
 */
public class AddBuddyListener implements ActionListener{

    private JTextField nameField;
    private JTextField phoneField;
    private AddressBook book;

    @Override
    public void actionPerformed(ActionEvent e) {
        BuddyInfo buddy = new BuddyInfo(nameField.getText(),phoneField.getText());
        book.addBuddy(buddy);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public void setPhoneField(JTextField phoneField) {
        this.phoneField = phoneField;
    }

    public AddressBook getBook() {
        return book;
    }

    public void setBook(AddressBook book) {
        this.book = book;
    }
}
