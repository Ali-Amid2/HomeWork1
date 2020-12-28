package org.example.gui;

/**
 * This interface is used for the communication between different components of the GUI
 */
public interface SendInformation {
    public void sendInformation(String registrationNumber, String frequency);
    public double[] performOne();
    public double[] performTwo();
    public double[] performThree();


}
