package org.example.basics;

public class Expressions {
    public static void main(String[] args) {
        // keywords are of two types in java reserved keywords and contextual keywords
        boolean isCondition = false;
        boolean isCondition1 = false;
        if(isCondition) {
            System.out.println("Never printed");
        }else if (isCondition1) {
            System.out.println("Never printed");
        }else {
            System.out.println("Printed");
        }

        // A method decalres executable code that cna be invoked. passing a fixed number of values as arguments

        // static keyword allows for the method to be directly called using the class name
        calculateScore();
        System.out.println(addNum(1,2));

        // Method overloading refers to when a class has multiple methods with the same name but
        // the methods are declared with different parameters

        // Method signature consists of the name of the method and the uniqueness of the declaration of its parameters
        // A method's return type is not part of the signature
        // A parameter name is also not part of the signature
        // The type, order, and number of parameters in conjunction with the name, make a method signature unique
        // A unique method signature is key for the java compiler to determine if a method is overloaded correctly
        System.out.println(addNum(1,2,3));
    }

    public static void calculateScore() {
        System.out.println("Calculate score method");
    }

    public static int addNum(int a, int b) {
        return a + b;
    }

    public static int addNum(int a, int b, int c) {
        return a + b + c;
    }
}
