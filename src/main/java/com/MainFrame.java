package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by jeremydunsmore on 1/26/2017.
 */
public class MainFrame extends JFrame {

    private List<Component> components;

    public void init(){
        this.setTitle("Address Book");
        this.setLayout(new GridLayout(2,1));
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(Component c : components){
            this.add(c );
        }
        this.setVisible(true);
    }

    public static void main(String args[]){
        String[] contextPaths = new String[] { "app-config.xml" };
        new ClassPathXmlApplicationContext(contextPaths);
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
