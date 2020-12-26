package org.example;

import processing.core.PApplet;

/**
 * Hello world!
 *
 */
public class App extends PApplet
{
    public static void main( String[] args )
    {
        PApplet.main(App.class,args);
    }

    PowerEquation powerEquation;

    @Override
    public void settings() {
        this.size(800,600);
    }

    @Override
    public void setup() {
        powerEquation = new PowerEquation(122308,2,this);

    }



    @Override
    public void draw() {
        powerEquation.plot();

    }

    @Override
    public void mouseClicked() {
        powerEquation.IntegralMethodThree();
    }
}
