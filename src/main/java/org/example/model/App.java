package org.example.model;

import processing.core.PApplet;

/**
 * Hello world!
 *
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



    public void sendInformation(String registrationNumber, String frequency) {

        this.registrationNumber = Double.parseDouble(registrationNumber);
        this.frequency = Double.parseDouble(frequency);
        String[] processingArgs = {"sketch1"};
        PApplet.runSketch(processingArgs, this);


    }

    public double[] performOne(){
        return powerEquation.IntegralMethodOne();

    }
    public double[] performTwo(){
        return powerEquation.IntegralMethodTwo();

    }
    public double[] performThree(){
        return powerEquation.IntegralMethodThree();

    }
}


