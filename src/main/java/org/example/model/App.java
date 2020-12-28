package org.example.model;

import processing.core.PApplet;

/**
 * This class is the Model part of the MVC. it handles the processing and sketching part
 */
public class App extends PApplet
{


    private double registrationNumber;
    private double frequency;
    PowerEquation powerEquation;


    @Override
    public void settings() {
        this.size(800,600);



    }

    @Override
    public void setup() {

        powerEquation = new PowerEquation(registrationNumber,frequency,this);


    }



    @Override
    public void draw() {

            powerEquation.plot();


    }


    /**
     * This method receives the information from GUI and starts the Processing library
     * @param registrationNumber
     * @param frequency
     */
    public void sendInformation(String registrationNumber, String frequency) {

        this.registrationNumber = Double.parseDouble(registrationNumber);
        this.frequency = Double.parseDouble(frequency);
        String[] processingArgs = {"sketch1"};
        PApplet.runSketch(processingArgs, this);


    }

    /**
     * This method performs the first method of the numerical calculation
     * @return exactValue and Numerical Value of the Integration
     */

    public double[] performOne(){
        return powerEquation.IntegralMethodOne();

    }
    /**
     * This method performs the second method of the numerical calculation
     * @return exactValue and Numerical Value of the Integration
     */
    public double[] performTwo(){
        return powerEquation.IntegralMethodTwo();

    }
    /**
     * This method performs the third method of the numerical calculation
     * @return exactValue and Numerical Value of the Integration
     */
    public double[] performThree(){
        return powerEquation.IntegralMethodThree();

    }
}


