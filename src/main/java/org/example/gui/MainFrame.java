package org.example.gui;

import org.example.controller.Controller;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {


    private FormPanel formPanel;
    private Controller controller;

    /**
     * This class is the hearth of the GUI and it sends and receives data from the Controller
     * @param title
     */
    public MainFrame(String title)  {
        super(title);
        formPanel = new FormPanel();
        setLayout(new BorderLayout());
        add(formPanel,BorderLayout.CENTER);
        controller = new Controller();


        setSize(550,500);
        setResizable(false);
        setMaximumSize(new Dimension(350,250));
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //communication of the GUI and Controller
      formPanel.setSendInformation(new SendInformation() {
          @Override
          public void sendInformation(String registration, String frequency) {

              controller.sendInformation(registration,frequency);
          }

          @Override
          //it performs the first method and will get the results -> the exact result and the numerical result
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
