package org.example.basics;

import java.util.Scanner;

public class ClassBasics {

    // A class can be described as custom data type nad is a block of code that can store methods
    // A class is like an empty form that gets copied and handed out ( in objects)
    // An object is called an instance of a particular class
    // new keyword creates an instance of a class and you can optionally pass data when creating that instance to setup on that object
    public static void main(String[] args) {
        String s = "Hello";
        String sNew = new String("Hello");

        // Static field/method
        // Requires static keyword when declared on the class
        // Value of the field is stored in special memory location and only in one place
        // Value is accessed by CLassName.fieldName Ex: Integer.MAX_VALUE

        // Instance field/method
        // OMits static keyword when declared on the class
        // Value of the field is not allocated any memory and has no value until the object is created
        // Value is accessed by ObjectVariable.fieldName

        //Methods are not stored in memory like fields(variables)

        String currentYear = "2024";
        int currYear = Integer.parseInt(currentYear);

        // System.COnsole cannot be used from intellij
        String name = "";

        try{
            name = getInputFromScanner();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println(name);
        }
    }

    public static String getInputFromScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your name");
        return sc.nextLine();
    }
}
