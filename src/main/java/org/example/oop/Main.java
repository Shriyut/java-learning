package org.example.oop;

public class Main {
    public static void main(String[] args) {
        // A class can be described as custom data type nad is a block of code that can store methods
        // A class is like an empty form that gets copied and handed out ( in objects)
        // An object is called an instance of a particular class
        // new keyword creates an instance of a class and you can

        //if package isn't defined then stored in default package by default

        // a class is said to be a top-level class if it is defined in the source code file
        // and not enclosed in the code block of another class, type, or method
        // 2 valid access modifier for top-level class public or none

        //When there is no modifier specified then the class is accessible only to the classes in the same package

        Car car = new Car();
        car.describeCar(); // 0 door null Tesla null

        Car car_new = new Car();
//        car_new.make = "Prosche"; // since desclared private, we cannot change it

        // null is a special keyword in java, meaning, the variable or attribute has a type but no reference to an object
        //this means that no instance or object is assigned to the variable or field
        // fields with primitive data types are never null


        // GETTERS AND SETTERS - helps in encapsulation

        // A getter is a method on a class that retrieves the value of a private field and returns it
        // A setter is a method on a class that sets the value of a private field
        // The purpose of these methods is to control and protect access to rpivate fields

        System.out.println(car_new.getMake()); // Tesla
        car_new.setMake("Porsche");
        System.out.println(car_new.getMake()); // Porsche


        // Constructor
        // A constructor is a special method that is called when an object is instantiated
        // It is used to initialize the object
        // you can never include a return type from a constructor, not even void

        Account bobsAccount = new Account("12345", 500,
                "Bob Brown", "myemail@bob.com",
                "(087) 123-4567");

        System.out.println(bobsAccount.getNumber());
        System.out.println(bobsAccount.getBalance());

//        bobsAccount.setNumber("12345");
//        bobsAccount.setBalance(1000.00);
//        bobsAccount.setCustomerName("Bob Brown");
//        bobsAccount.setCustomerEmail("myemail@bob.com");
//        bobsAccount.setCustomerPhone("(087) 123-4567");

        bobsAccount.withdrawFunds(100.0);
        bobsAccount.depositFunds(250);
        bobsAccount.withdrawFunds(50);

        bobsAccount.withdrawFunds(200);

        bobsAccount.depositFunds(100);
        bobsAccount.withdrawFunds(45.55);
        bobsAccount.withdrawFunds(54.46);

        bobsAccount.withdrawFunds(54.45);

        Account timsAccount = new Account("Tim",
                "tim@email.com", "12345");
        System.out.println("AccountNo: " + timsAccount.getNumber() +
                "; name " + timsAccount.getCustomerName());

        Customer customer = new Customer("Tim", 1000,
                "tim@email.com");
        System.out.println(customer.getName());
        System.out.println(customer.getCreditLimit());
        System.out.println(customer.getEmail());

        Customer secondCustomer = new Customer();
        System.out.println(secondCustomer.getName());
        System.out.println(secondCustomer.getCreditLimit());
        System.out.println(secondCustomer.getEmail());

        Customer thirdCustomer = new Customer("Joe", "joe@email.com");
        System.out.println(thirdCustomer.getName());
        System.out.println(thirdCustomer.getCreditLimit());
        System.out.println(thirdCustomer.getEmail());

        for (int i = 1; i <= 5; i++) {
            Student s = new Student("S92300" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        case 5 -> "Lisa";
                        default -> "Anonymous";
                    },
                    "05/11/1985",
                    "Java Masterclass");
            System.out.println(s);
        }

        Student pojoStudent = new Student("S923006", "Ann",
                "05/11/1985", "Java Masterclass");
        LPAStudent recordStudent = new LPAStudent("S923007", "Bill",
                "05/11/1985", "Java Masterclass");

        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        pojoStudent.setClassList(pojoStudent.getClassList() + ", Java OCP Exam 829");
//        recordStudent.setClassList(recordStudent.classList() + ", Java OCP Exam 829");

        System.out.println(pojoStudent.getName() + " is taking " +
                pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking " +
                recordStudent.classList());
    }
}
