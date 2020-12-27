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
    public void performOne() {
        app.performOne();
    }

    public void performTwo() {
        app.performTwo();

    }
    public void performThree() {
        app.performThree();

    }
//
//    public Boolean generateCSVFile(File file) {
//        return model.generateCSVFile(file);
//    }
}
