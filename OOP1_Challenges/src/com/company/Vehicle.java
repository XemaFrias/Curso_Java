package com.company;

public class Vehicle {
    private String surface;
    private String movement;
    private int speed;
    private String direction;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Vehicle(String surface, String movement, int speed, String direction) {
        this.surface = surface;
        this.movement = movement;
        this.speed=speed;
        this.direction=direction;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public void changeDirection(){
        System.out.println("Vehicle() changing directions");
    }

    public void changeSpeed(){
        System.out.println("Vehicle() changing speed");
    }
    public void accelerate(){
        changeSpeed();
        this.speed+=1;
        System.out.println("New Speed = "+getSpeed());
    }
    public void decelerate(){
        if (this.speed>0){
            changeSpeed();
            this.speed-=1;
        }
        else{
            System.out.println("Vehicle is already stopped");
        }
    }
}
