package org.example.controller;



import org.example.model.App;


public class Controller {

    private App app;

//    private Model model;
//
    public Controller() {
        app = new App();



    }
//
    public void sendInformation(String registrationNumber, String frequency) {



        app.sendInformation(registrationNumber,frequency);
    }
//
    public double[] performOne() {
        return app.performOne();
    }

    public double[] performTwo() {
        return app.performTwo();

    }
    public double[] performThree() {
        return app.performThree();

    }
//
//    public Boolean generateCSVFile(File file) {
//        return model.generateCSVFile(file);
//    }
}
