package org.example;


import grafica.GPoint;
import grafica.GPointsArray;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;
import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PowerEquation {

    PApplet pApplet;
    double registrationNumber;
    double frequency;
    FunctionPlotter1D plotter;
    private GPointsArray points;
    private List<GPoint> pointsOfEquation = new ArrayList<>();



    public PowerEquation(double registrationNumber, double frequency, PApplet pApplet) {
        this.pApplet = pApplet;
        this.registrationNumber = registrationNumber;
        this.frequency = frequency;
        getFunction();
    }

    private void getFunction() {

        double a1 = registrationNumber/40000;
        //make power equation form the homework pdf
        Function function = new Function(String.format("f(t) = %f*t+sin(2*pi*%f*t)",a1,this.frequency));
        // consider time between 0 and 20 seconds
        this.plotter = new FunctionPlotter1D(function, 0, 20);

        // get the points of the power equation from plotter class, this will be GPointsArray and not array.
        points = this.plotter.getPoints();

        // get the points from the plotter class because the list of points is restricted in the GPointsArray class
        // and put it into the arraylist.
        // the size will be 500 points, to change it go to the FunctionPlotter class
        for (int i=0; i<points.getNPoints(); i++){
            this.pointsOfEquation.add(points.get(i));
        }
        // delta will be 0.04 sec
//        for (GPoint gPoint: pointsOfEquation){
//            System.out.println("x= " + gPoint.getX() + " y= " + gPoint.getY());
//        }



    }
    public void plot(){
        this.plotter.plot(this.pApplet);
    }

    public void IntegralMethodOne() {
        double area = 0;
        for(int i = 0; i<pointsOfEquation.size()-1;i++){
            GPoint gPoint1 = pointsOfEquation.get(i+1);
            GPoint gPoint0 = pointsOfEquation.get(i);
            area = area + (gPoint1.getX()-gPoint0.getX()) * gPoint0.getY();
            // ignore the sketch of the first rectangle because the area is zero
            if(gPoint0.getY() != 0){
                this.plotter.addLine(new GPoint(gPoint0.getX(),0),new GPoint(gPoint1.getX(),0), Color.BLUE);
                this.plotter.addLine(gPoint0,new GPoint(gPoint1.getX(),gPoint0.getY()), Color.BLUE);
                this.plotter.addLine(new GPoint(gPoint0.getX(),0),gPoint0, Color.BLUE);
                this.plotter.addLine(new GPoint(gPoint1.getX(),0),new GPoint(gPoint1.getX(),gPoint0.getY()), Color.BLUE);
            }

        }
        System.out.println(area);

    }

    public void IntegralMethodTwo(){
        double area = 0;
        for(int i = 0; i<pointsOfEquation.size()-1;i++){
            GPoint gPoint1 = pointsOfEquation.get(i+1);
            GPoint gPoint0 = pointsOfEquation.get(i);
            double meanY = (gPoint0.getY()+gPoint1.getY())/2;
            area = area + (gPoint1.getX()-gPoint0.getX()) * meanY;


            this.plotter.addLine(new GPoint(gPoint0.getX(),0),new GPoint(gPoint1.getX(),0), Color.BLUE);
            this.plotter.addLine(new GPoint(gPoint0.getX(),(float)meanY),new GPoint(gPoint1.getX(),(float)meanY), Color.BLUE);
            this.plotter.addLine(new GPoint(gPoint0.getX(),0),new GPoint(gPoint0.getX(),(float)meanY), Color.BLUE);
            this.plotter.addLine(new GPoint(gPoint1.getX(),0),new GPoint(gPoint1.getX(),(float)meanY), Color.BLUE);


        }
        System.out.println(area);

    }

    public void IntegralMethodThree(){
        double area = 0;
        for(int i = 0; i<pointsOfEquation.size()-1;i++){
            GPoint gPoint1 = pointsOfEquation.get(i+1);
            GPoint gPoint0 = pointsOfEquation.get(i);
            double meanY = (gPoint0.getY()+gPoint1.getY())/2;
            area = area + (gPoint1.getX()-gPoint0.getX()) * meanY;


            this.plotter.addLine(new GPoint(gPoint0.getX(),0),new GPoint(gPoint1.getX(),0), Color.BLUE);
            this.plotter.addLine(new GPoint(gPoint0.getX(),(float)meanY),new GPoint(gPoint1.getX(),(float)meanY), Color.BLUE);
            this.plotter.addLine(new GPoint(gPoint0.getX(),0),new GPoint(gPoint0.getX(),(float)meanY), Color.BLUE);
            this.plotter.addLine(new GPoint(gPoint1.getX(),0),new GPoint(gPoint1.getX(),(float)meanY), Color.BLUE);


        }
        System.out.println(area);


    }
}
