package com;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jeremydunsmore on 1/26/2017.
 */
public class BuddyPanel extends JPanel  {


    private JTextField nameField;
    private JTextField phoneField;
    private JButton addBuddy;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private AddBuddyListener addListener;

    public  void init(){
        this.nameLabel = new JLabel("Name");
        this.phoneLabel = new JLabel("Phone");
        this.addBuddy = new JButton("Add");
        this.setLayout(  new GridLayout(3,2));
        addBuddy.addActionListener(addListener);
        this.add(nameLabel);
        this.add(nameField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(addBuddy);
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

    public JButton getAddBuddy() {
        return addBuddy;
    }

    public void setAddBuddy(JButton addBuddy) {
        this.addBuddy = addBuddy;
    }
    public AddBuddyListener getAddListener() {
        return addListener;
    }

    public void setAddListener(AddBuddyListener addListener) {
        this.addListener = addListener;
    }

}
