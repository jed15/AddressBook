package com;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jeremydunsmore on 1/26/2017.
 */
public class AddressPanel extends JPanel{
    private JList buddiesList;
    private DefaultListModel<String> buddies;
    private AddressBook book;
    private JButton refresh;
    private RefreshListener refreshListener;

    public void init(){
        buddies = new DefaultListModel<>();
        refresh = new JButton("refresh");
        this.book=book;
        this.setLayout(new GridLayout(2,1));
        refresh.addActionListener(refreshListener);
        this.add(buddiesList);
        this.add(refresh);

    }


    public JList getBuddiesList() {
        return buddiesList;
    }

    public void setBuddiesList(JList buddiesList) {
        this.buddiesList = buddiesList;
    }

    public DefaultListModel<String> getBuddies() {
        return buddies;
    }

    public void setBuddies(DefaultListModel<String> buddies) {
        this.buddies = buddies;
    }

    public AddressBook getBook() {
        return book;
    }

    public void setBook(AddressBook book) {
        this.book = book;
    }

    public RefreshListener getRefreshListener() {
        return refreshListener;
    }

    public void setRefreshListener(RefreshListener refreshListener) {
        this.refreshListener = refreshListener;
    }
}
