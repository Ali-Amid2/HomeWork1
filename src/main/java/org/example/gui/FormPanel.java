package org.example.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JLabel registrationLabel;
    private JTextField registrationField;
    private JLabel frequency;
    private JTextField frequencyField;
    private JButton plotButton;
    private JButton firstMethodButton;
    private JButton secondMethodButton;
    private JButton thirdMethodButton;



    private SendInformation sendInformation;


    public FormPanel() {
        this.registrationLabel = new JLabel("Enter your Registration Number:");
        this.registrationField = new JTextField("122308",10);

        this.frequency = new JLabel("Enter your Frequency:");
        this.frequencyField = new JTextField("2",10);


        setBackground(new Color(17, 167, 236));

        this.plotButton = new JButton("Plot the Power Equation");
        this.firstMethodButton = new JButton("Perform the first Method");
        this.secondMethodButton = new JButton("Perform the second Method");
        this.thirdMethodButton = new JButton("Perform the third Method");
        Dimension dimensionOfCombinedButton = thirdMethodButton.getPreferredSize();
        firstMethodButton.setPreferredSize(dimensionOfCombinedButton);
        secondMethodButton.setPreferredSize(dimensionOfCombinedButton);
        plotButton.setPreferredSize(dimensionOfCombinedButton);
        setLayout(new GridBagLayout());
        arrangeComponents();
        Border Innerborder = BorderFactory.createEmptyBorder(0, 10, 10, 10);
        Border Outerborder = BorderFactory.createTitledBorder("OOP HomeWork1");
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
                   JOptionPane.showMessageDialog(FormPanel.this,String.format("Exact value of the Integration: %f\n" +
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
                    double absoluteError = results[1] - results[0];
                    double relativeError = Math.abs(absoluteError/results[0]) * 100 ;
                    JOptionPane.showMessageDialog(FormPanel.this,String.format("Exact value of the Integration: %f\n" +
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
                    JOptionPane.showMessageDialog(FormPanel.this,String.format("Exact value of the Integration: %f\n" +
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

    //        triggerButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser importDialog = new JFileChooser();
//                //adding filter to the files selection:
//                importDialog.addChoosableFileFilter(new Choosefilefilter());
//
//                //Show OpenDialogbox and only if the user specifies a file and click on OK, go and print the file on the terminal
//                if (importDialog.showOpenDialog(FormPanel.this) == JFileChooser.APPROVE_OPTION) {
//                    if ( sendFile !=null){
//                        sendFile.sendTriggerFile(importDialog.getSelectedFile());
//                    }
//
//                }

//            }
//        });

//        roverButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser importDialog = new JFileChooser();
//                //adding filter to the files selection:
//                importDialog.addChoosableFileFilter(new Choosefilefilter());
//
//                //Show OpenDialogbox and only if the user specifies a file and click on OK, go and print the file on the terminal
//                if (importDialog.showOpenDialog(FormPanel.this) == JFileChooser.APPROVE_OPTION) {
//                    if ( sendFile !=null){
//                        sendFile.sendRoverFile(importDialog.getSelectedFile());
//                    }
//
//                }


//            }
//        });

//        combinedButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser exportDialog = new JFileChooser();
//                if (exportDialog.showSaveDialog(FormPanel.this) == JFileChooser.APPROVE_OPTION) {
//                    if (sendFile != null){
//                        if (sendFile.generateCSVFile(exportDialog.getSelectedFile())){
//                            JOptionPane.showMessageDialog(FormPanel.this,"CSV has been created Maryam","Warning", JOptionPane.INFORMATION_MESSAGE);
//                        }else{
//                            JOptionPane.showMessageDialog(FormPanel.this,"Error occured", "Error",JOptionPane.ERROR_MESSAGE);
//
//                        }
//                    }
//                }
//
//            }
//        });
//    }


//    public void setSendFile(SendFile sendFile) {
//        this.sendFile = sendFile;
//    }

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
        g.insets = new Insets(0, 0, 0, 5);
        add(registrationLabel, g);

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
        add(registrationField, g);


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
        add(frequency, g);

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
        add(frequencyField, g);

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
        add(plotButton, g);

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
        add(firstMethodButton, g);




        g.gridx = 0;
        g.gridy = 6;
        g.insets = new Insets(0, 0, 0, 0);
        add(secondMethodButton, g);

        g.gridx = 0;
        g.gridy = 7;
        g.insets = new Insets(0, 0, 0, 5);
        add(thirdMethodButton, g);



    }




}

