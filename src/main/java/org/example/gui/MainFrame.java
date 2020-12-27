package org.example.gui;

//import org.example.controller.Controller;

import org.example.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainFrame extends JFrame {


    private FormPanel formPanel;
    private Controller controller;


    public MainFrame(String title)  {
        super(title);
        formPanel = new FormPanel();
        setLayout(new BorderLayout());
        add(formPanel,BorderLayout.CENTER);
        controller = new Controller();


        setSize(400,300);
        setResizable(false);
        setMaximumSize(new Dimension(350,250));
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      formPanel.setSendInformation(new SendInformation() {
          @Override
          public void sendInformation(String registration, String frequency) {

              controller.sendInformation(registration,frequency);
          }

          @Override
          public double[] performOne() {
              return controller.performOne();

          }

          @Override
          public double[] performTwo() {
              return controller.performTwo();

          }

          @Override
          public double[] performThree() {
              return controller.performThree();

          }
      });



    }


}
