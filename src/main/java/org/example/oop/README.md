# Object Oriented Programming

Fundamental features of OOP
 - Inheritance
 - Encapsulation
 - Polymorphism
 - Composition
 - Abstraction

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects", which can contain data and code to manipulate that data. Here are the fundamental features of OOP:

1. Inheritance: This allows a class to inherit properties and methods from another class. It promotes code reusability and establishes a relationship between parent and child classes.
2. Encapsulation: This is the bundling of data and methods that operate on the data within one unit, e.g., a class. It restricts direct access to some of the object's components, which can prevent the accidental modification of data.
3. Polymorphism: This allows objects to be treated as instances of their parent class rather than their actual class. The most common use of polymorphism is when a parent class reference is used to refer to a child class object.
4. Composition: This is a design principle where a class is composed of one or more objects from other classes, implying a has-a relationship. It is used to build complex types by combining objects of other types.
5. Abstraction: This is the concept of hiding the complex implementation details and showing only the necessary features of an object. It helps in reducing programming complexity and effort.

If a field is static, there is only one copy in memory, and this value is associated with the class or template itself. \
If a field is not static, it's called an instance field, and each object may have a different value stored for this field.  
A static method can't be dependent on any one object's state, so it can't reference any instance members.
In other words, any method that operates on instance fields needs to be non-static.

An access modifier at the member level allows granular control over class members
- public: accessible from any other class
- protected: accessible from the same class, subclasses, and classes in the same package
- private: no other class can access this member

A class can have multiple constructors, as long as they have different parameter lists. This is called constructor overloading.

The `this` keyword is a reference to the current object. It is used to differentiate between instance variables and parameters with the same name.


## Reference vs Object vs Instance vs Class

- **Class**: A blueprint for creating objects. It defines the properties and behaviors that objects of the class all share.
- **Object**: An instance of a class. It is a concrete entity based on a class and has state and behavior.
- **Instance**: A single occurrence of an object. An object is an instance of a class.
- **Reference**: A reference is a value that refers to an object. It is not the object itself but a way to access it.

We can pass references to methods, and the method can modify the object's state. This is because the reference is pointing to the same object in memory.

## Static vs Instance variables

- **Static variables**: These are shared among all instances of a class. They are associated with the class itself rather than with any object. They are initialized only once, at the start ( no need to create instance to access)
- **Instance variables**: These are unique to each instance of a class. They are created when an object is instantiated and are destroyed when the object is destroyed.

If changes are made to the static variable, all other instances of that class will see the effect of that change

```java
class Dog {
    private static String name; // if static is removed i.e. name were an isntance variable then respective names would be printed in main class
    
    public Dog(String name) {
        Dog.name = name;
    }
    
    public void printName() {
        System.out.println(name);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Buddy");
        Dog dog2 = new Dog("Max");
        
        dog1.printName(); // Max - since max was instantiated later
        dog2.printName(); // Max
    }
}
```

## Static vs Instance methods

- **Static methods**: These belong to the class rather than to any instance. They can be called without creating an instance of the class. They can't access instance variables or methods.
- **Instance methods**: These belong to the instance of the class. They can access instance variables and methods. They are called on an instance of the class.

Static methods can't access instance methods and instant variables directly
They're usually used for operations that don't require any data from an instance of the class(from this keyword - current object)

Inside static methods we cant use the this keyword

Instance methods can access instance variables and methods directly as well as static methods and variables

```java
class Calculator {
    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator.printSum(5, 10); // 15
        printHello(); // Hello
    }
    
    public static void printHello() {
        System.out.println("Hello");
    }
}
```

### POJO - Plain Old Java Object

A plain old java object (POJO) is a class that generally only has instance fields, getters, setters, and constructors. It is used to encapsulate data and provide access to it.

A POJO is also called a bean or JavaBean. 
A JavaBean is ust a POJO with some extra rules applied to it, another acronym is DTO for Data Transfer Object.


### Record classes

Introduced in Java 14, record classes are a new type of class that is designed to be a simple and concise way to create classes that are used primarily to store data. They are similar to POJOs but with less boilerplate code.
Java generates a toString method that prints out each attribute in a formatted string. In addition to creating a private final field for each component, java generates a public accessor method for each component.
This method has the same name and type of the component, but it doesn't have any kind of special prefic or suffix. It also generates an equals and hashcode method that compares the components of the record class.

## Inheritance

Inheritance is a mechanism in which one class acquires the properties and behaviors of another class. The class that is inherited from is called the superclass or parent class, and the class that inherits is called the subclass or child class.

super() is a way to call constructor on the super class directly from the sub class's constructor, similarly like this() it has to be the first statement of the constructor.
Because of this rule this() and super() cannot be called from the same constructor

Object class is the root class of all classes in Java. It is the superclass of all other classes. It has methods that are inherited by all other classes, such as equals(), hashCode(), and toString().

In Java we can only inherit from one class, so multiple inheritance is not supported. However, we can implement multiple interfaces.



### this vs super

The keyword super is used to access or call the parent class members (variables and methods). 

The keyword this is used to call the current class members (variables and methods).

this is required when we have a parameter with the same name as an instance variable(for example in setters). It is used to differentiate between the instance variable and the parameter.

We can use either of these two keywords anywhere in a class except for static elements ( will lead to compile time error)

this() and super() are used to call constructors. this() is used to call a constructor of the same class, and super() is used to call a constructor of the parent class.

```java
// Example of constructor chaining

class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle() {
        this(0, 0);
    }

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
```

```java
// Example of super keyword
class Shape {
    private int x;
    private int y;
    
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle extends Shape{
    
    private int width;
    private int height;
    
    // 1st constructor
    public Rectangle(int x, int y) {
        this(x, y, 0, 0); // calls 2nd constructor
    }
    
    // 2nd constructor
    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
}
```

### Method Overloading vs Method Overriding

- **Method overloading**: This is when two or more methods in the same class have the same method name but different parameters. The methods can have different return types or different numbers of parameters. Method overloading is also known as compile-time polymorphism or static polymorphism.
- **Method overriding**: This is when a subclass provides a specific implementation of a method that is already provided by its parent class. The method in the subclass has the same name, return type, and parameters as the method in the parent class. Method overriding is also known as runtime polymorphism or dynamic polymorphism.

Subclass inherits one version of the method from the parent class and the subclass can have another overloaded version of that method
The @Override statement is not required but it's a way to get the compiler to flag an error if you don't properly override this method

We can't override static methods only instance methods can be overridden

```java
// Method overriding example - same name with same parameters
class Dog {
    public void bark() {
        System.out.println("Woof");
    }
}

class GermanShepherd extends Dog {
    @Override
    public void bark() {
        System.out.println("Woof Woof");
    }
}
```

```java
// Method overloading example - same name with different parameters
class Dog {
    public void bark() {
        System.out.println("Woof");
    }
    
    public void bark(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Woof");
        }
    }
}
```
![Overloading vs Overriding](image.png)

## Composition

Composition is a design principle in object-oriented programming that models a has-a relationship. It allows one class to contain an object of another class as a field. This is different from inheritance, which models an is-a relationship.

Inheritance is a way to reuse functionality and attributes, composition is a way to amke the combination of classes act like a single coherent object.

As a rule look at using composition first before using implementing inheritance

The reasons composition is preferred over inheritance:

- Composition is more flexible, you can add parts in or remove them, and these changes are less likely to have a downstream effect
- Composition provides functional reuse outside of the class hierarchy, meaning classes can share attributes and behavior, by having similar components, instead of inheriting functionality from a parent or base class
- Java's inheritance breaks encapsulation because subclasses may need direct access to a parent's state or behavior

Inheritance is less flexible

- Adding a class to or removing a class from a class hierarchy may impact all subclasses from that point
- A new subclass may not need all the functionality or attributes of its parent class

## Encapsulation

Encapsulation is a fundamental principle in object-oriented programming that restricts direct access to some of an object's components. It is a way to protect the data in a class by hiding the implementation details and providing access to the data through public methods.

Why would we want to hide things in Java?

- To make the interface simpler, we may want to hide unnecessary details.
- To protect the integrity of data on an obejct, we may hide or restrict access to some of the data and operations
- To decouple the published interface from the internal details of the class, we may hide actual names nad types of class members

Encapsulation is achieved by declaring the fields of a class as private and providing public methods to access and modify those fields. These methods are called getters and setters.

Allowing direct access to data on an object can bypass checks and operations.

It encourages an interdependency or coupling between the calling code and the class

Encapsulation prevents calling code from bypassing the rules and constraints we've built into the class.

To create an encapsulated class, you want to:

- Create constructors for object initialization, which enforces that only objects with valid daa will get created
- Use the private access modifier for your fields
- Use setter methods sparingly and only as needed
- Use access modifiers that aren't private, only for the methods that the calling code needs to use

## Polymorphism

Polymorphism is a fundamental concept in object-oriented programming that allows objects to be treated as instances of their parent class rather than their actual class. It allows for flexibility and extensibility in code.

Polymorphism in Java allows us to write code that can call a method, but the actual method that gets executed can be different for different obejcts at runtime.

This means that the behavior that occurs during program execution depends on the runtime type of the object, which might differ from its declared type in the code.

For polymorphism to work, the declared type must have a relationship with the runtime type. Inheritance is one way to establish this relationship, where a subclass can override a method from its superclass, enabling polymorphic behavior.

Polymorphism is achieved through method overriding, where a subclass provides a specific implementation of a method that is already provided by its parent class. The method in the subclass has the same name, return type, and parameters as the method in the parent class.

Polymorphism is also achieved through method overloading, where two or more methods in the same class have the same method name but different parameters. The methods can have different return types or different numbers of parameters.

