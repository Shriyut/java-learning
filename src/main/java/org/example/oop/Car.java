package org.example.oop;

public class Car {

    private String make = "Tesla";
    private String model;
    private String color;
    private int doors;
    private boolean convertible;

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public String getMake(){
        return make; //not added static since we're working with non static fields

    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public void setMake(String make){
//        this.make = make;
        // this is a special keyword in java
        // refers to the instance that was created when the object was instantiated
        // this keyword is used to refer to the current object and we can use this to access fields on the class

        // sample usage to show we can have validation in setters
        if (make == null) make = "Unknown";
        String lowerCaseMake = make.toLowerCase();
        switch(lowerCaseMake) {
            case "holden", "porsche", "tesla" -> this.make = make;
            default -> {
                this.make = "Unsupported";
            }
        }
    }

    public void describeCar() {
        System.out.println(doors + " door " + color + " " + make + " " + model);
    }
}
