package org.example.oop;

public class Dog extends Animal {

    // Dog "IS A" Animal

    private String earShape;
    private String tailShape;

    public Dog(){
//        super("Dog", "Medium", 20); // passes values to parent class's constructor
//        super(); // calls the parent class's constructor with no arguments
        super("Mutt", "Big", 50 );  // passes values to parent class's constructor
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    public Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString(); // calls tostring of parent class
    }

    public void makeNoise() {
        // makenoise from parent class will not be invoked and this method will be invoked
        // method overriding
        if ( type == "Wolf") {
            System.out.print("Ow Wooooo!");
        }
        bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        super.move(speed); // calling move method on parent class
        System.out.println("Dogs run, walk, and wag their tails");
        if ( speed == "slow") {
            walk();
            wagTail();
        }else {
            run();
            bark();
        }
    }

    private void bark() {
        System.out.println("Dog barks");
    }

    private void run() {
        System.out.println("Dog running");
    }

    private void walk() {
        System.out.println("Dog walking");
    }

    private void wagTail() {
        System.out.println("Dog wagging its tail");
    }
}
