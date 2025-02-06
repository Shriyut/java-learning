package org.example.oop;

public class Animal {

    protected String type; // any subclass can access this field but not the other two fields mentioned here
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public Animal() {

    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void move(String speed) {
        System.out.println(type + " moves "+ speed);
    }

    public void makeNoise() {
        System.out.println(type + " make some kind of noise");
    }
}
