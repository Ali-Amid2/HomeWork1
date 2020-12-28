package org.example.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JLabel stepsLabel;
    private JLabel registrationLabel;
    private JTextField registrationField;
    private JLabel frequency;
    private JTextField frequencyField;
    private JButton plotButton;
    private JButton firstMethodButton;
    private JButton secondMethodButton;
    private JButton thirdMethodButton;
    private JLabel licence;



    private SendInformation sendInformation;


    public FormPanel() {
        this.stepsLabel = new JLabel("<html><p>Note1: 12 grid points per second has been considered for numerical calculation</p>" +
                "                           <p>Note2: 25 grid points per second has been considered for the sketching of the function</p>" +
                "                           <p>Note3: Press on 'Plot the Power Equation' first, then click on the desired method</p></html>" );

        this.registrationLabel = new JLabel("Enter your Registration Number:");
        this.registrationField = new JTextField("122308",10);

        this.frequency = new JLabel("Enter your Frequency:");
        this.frequencyField = new JTextField("2",10);


        setBackground(new Color(17, 167, 236));

        this.plotButton = new JButton("Plot the Power Equation");
        this.firstMethodButton = new JButton("Perform the first Method");
        this.secondMethodButton = new JButton("Perform the second Method");
        this.thirdMethodButton = new JButton("Perform the third Method");

        this.licence = new JLabel("This program has been created by Seyedali Amid (seyedali.amid@uni-weimar.de)");
        licence.setFont(new Font("Arial", Font.BOLD, 10));
        licence.setBorder(BorderFactory.createEtchedBorder());

        Dimension dimensionOfSeconedButton = secondMethodButton.getPreferredSize();
        firstMethodButton.setPreferredSize(dimensionOfSeconedButton);
        thirdMethodButton.setPreferredSize(dimensionOfSeconedButton);
        plotButton.setPreferredSize(dimensionOfSeconedButton);
        setLayout(new GridBagLayout());
        arrangeComponents();
        Border Innerborder = BorderFactory.createEmptyBorder(0, 10, 10, 10);
        Border Outerborder = BorderFactory.createTitledBorder("Numerical Integration Calculator");
        setBorder(BorderFactory.createCompoundBorder(Innerborder, Outerborder));


        plotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String registrationNumber = registrationField.getText();
                String frequencyNumber = frequencyField.getText();

                if (sendInformation != null) {
                    sendInformation.sendInformation(registrationNumber,frequencyNumber);
                }




            }
        });

        firstMethodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sendInformation != null) {
                   double[] results = sendInformation.performOne();
                   //calculate errors
                   double absoluteError = results[1] - results[0];
                   double relativeError = Math.abs(absoluteError/results[0]) * 100 ;
                   JOptionPane.showMessageDialog(FormPanel.this,String.format("Analytical value of the Integration: %f\n" +
                           "Numerical result of the first method: %f\n" +
                           "Absolute Error: %f\n" +
                           "Relative Error: %f percent ",results[0],results[1],absoluteError,relativeError),"Results of the first method", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        secondMethodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sendInformation != null) {
                   double[] results =  sendInformation.performTwo();
                    //calculate errors
                    //absoluteError = approximateValue - trueValue
                    double absoluteError = results[1] - results[0];
                    //relativeError = absoluteError/trueValue
                    double relativeError = Math.abs(absoluteError/results[0]) * 100 ;
                    JOptionPane.showMessageDialog(FormPanel.this,String.format("Analytical value of the Integration: %f\n" +
                            "Numerical result of the second method: %f\n" +
                            "Absolute Error: %f\n" +
                            "Relative Error: %f percent ",results[0],results[1],absoluteError,relativeError),"Results of the second method", JOptionPane.INFORMATION_MESSAGE);

                }

            }
        });

        thirdMethodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sendInformation != null) {
                    double[] results = sendInformation.performThree();
                    //calculate errors
                    double absoluteError = results[1] - results[0];
                    double relativeError = Math.abs(absoluteError/results[0]) * 100 ;
                    JOptionPane.showMessageDialog(FormPanel.this,String.format("Analytical value of the Integration: %f\n" +
                            "Numerical result of the third method: %f\n" +
                            "Absolute Error: %f\n" +
                            "Relative Error: %f percent ",results[0],results[1],absoluteError,relativeError),"Results of the third method", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
    }

    public void setSendInformation(SendInformation sendInformation) {
        this.sendInformation = sendInformation;
    }



    private void arrangeComponents() {

        GridBagConstraints g = new GridBagConstraints();
        // the size of cell relative to the other cells
        g.weightx = 1;
        g.weighty = 0.05;
        // in which cell do have to place the component
        g.gridx = 0;
        g.gridy = 0;
        // do not fill the cell completely with the component
        g.fill = GridBagConstraints.NONE;
//        g.anchor = GridBagConstraints.LINE_START;

        // padding of the component in the cell
        g.insets = new Insets(0, 0, 5, 5);
        add(stepsLabel, g);


        // the size of cell relative to the other cells
        g.weightx = 1;
        g.weighty = 0.1;
        // in which cell do have to place the component
        g.gridx = 0;
        g.gridy = 1;
        // do not fill the cell completely with the component
        g.fill = GridBagConstraints.NONE;

        // padding of the component in the cell
        g.insets = new Insets(0, 0, 0, 5);
        add(registrationLabel, g);











        // the size of cell relative to the other cells
        g.weightx = 1;
        g.weighty = 0.1;
        // in which cell do have to place the component
        g.gridx = 0;
        g.gridy = 2;
        // do not fill the cell completely with the component
        g.fill = GridBagConstraints.NONE;

        // padding of the component in the cell
        g.insets = new Insets(0, 0, 0, 5);
        add(registrationField, g);


        // the size of cell relative to the other cells
        g.weightx = 1;
        g.weighty = 0.1;
        // in which cell do have to place the component
        g.gridx = 0;
        g.gridy = 3;
        // do not fill the cell completely with the component
        g.fill = GridBagConstraints.NONE;

        // padding of the component in the cell
        g.insets = new Insets(0, 0, 0, 5);
        add(frequency, g);

        // the size of cell relative to the other cells
        g.weightx = 1;
        g.weighty = 0.1;
        // in which cell do have to place the component
        g.gridx = 0;
        g.gridy = 4;
        // do not fill the cell completely with the component
        g.fill = GridBagConstraints.NONE;

        // padding of the component in the cell
        g.insets = new Insets(0, 0, 0, 5);
        add(frequencyField, g);

        // the size of cell relative to the other cells
        g.weightx = 1;
        g.weighty = 0.1;
        // in which cell do have to place the component
        g.gridx = 0;
        g.gridy = 5;
        // do not fill the cell completely with the component
        g.fill = GridBagConstraints.NONE;

        // padding of the component in the cell
        g.insets = new Insets(0, 0, 0, 5);
        add(plotButton, g);

        // the size of cell relative to the other cells
        g.weightx = 1;
        g.weighty = 0.1;
        // in which cell do have to place the component
        g.gridx = 0;
        g.gridy = 6;
        // do not fill the cell completely with the component
        g.fill = GridBagConstraints.NONE;

        // padding of the component in the cell
        g.insets = new Insets(0, 0, 0, 5);
        add(firstMethodButton, g);




        g.gridx = 0;
        g.gridy = 7;
        g.insets = new Insets(0, 0, 0, 0);
        add(secondMethodButton, g);

        g.gridx = 0;
        g.gridy = 8;
        g.insets = new Insets(0, 0, 0, 5);
        add(thirdMethodButton, g);

        g.gridx = 0;
        g.gridy = 9;
        g.insets = new Insets(0, 0, 0, 5);
        add(licence, g);



    }




}

