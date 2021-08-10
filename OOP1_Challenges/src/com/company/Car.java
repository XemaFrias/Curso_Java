package com.company;

import java.util.Locale;

public class Car extends Vehicle{
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;
    private int gear;

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public Car(String surface, String movement, int speed, int doors, int wheels, String model, String engine, String colour, int gear,String direction) {
        super(surface, movement,speed,direction);
        this.doors = doors;
        this.wheels = wheels;
        this.model = model;
        this.engine = engine;
        this.colour = colour;
        this.gear=gear;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    private void changeGear(){
        System.out.println("Car() changing gears");
    }
    public void upGear(){
        changeGear();
        this.gear+=1;
    }
    public void downGear(){
        if (this.gear>1){
            changeGear();
            this.gear-=1;
        }
        else{
            System.out.println("Impossible to change to a lower gear");
        }
    }
    public void specificGear(int gear){
        changeGear();
        this.gear=gear;
    }
    private void stirringWheel(){
        System.out.println("Car() stirring wheel");
        super.changeDirection();
    }
    public void stirLeft(){
        stirringWheel();
        System.out.println("Car Stirring left");
    }
    public void stirRight(){
        stirringWheel();
        System.out.println("Car Stirring Right");
    }

}
