# Java Learning

Based on where a data type can be created in memory, it is called a primitive type or a reference type.

A primitive type can be created at a place in memory called stack, whereas a reference type can be created at a place in memory called heap.

Java forces certain data types to be created only in stack and certain only in heap.

## Primitive Types

The primitive data types in Java are:

- byte
- short
- int
- long
- float
- double
- char
- boolean
- Enumerations (user defined)

## Reference Types

The reference data types in Java are:

- Classes
- Interfaces
- Arrays
- Strings
- Objects

## Memory Allocation

- Stack Memory: Used for static memory allocation and the execution of a thread. It stores primitive data types and references to objects in heap memory. Stack memory is faster to access but has a limited size.
- Heap Memory: Used for dynamic memory allocation. It stores objects and their associated data. Heap memory is larger than stack memory but slower to access.
- Java Virtual Machine (JVM) manages both stack and heap memory, ensuring efficient memory allocation and garbage collection.
- Understanding the differences between primitive and reference types, as well as their memory allocation, is crucial for effective Java programming and performance optimization.
- Proper memory management helps prevent memory leaks and ensures optimal application performance.

## Classes and Objects

When you assign one object reference variable to another object reference variable, you are not creating a copy of the object, you are only making a copy of the reference.
Using the `new` keyword always creates a new object in the heap memory.

```java
class Box{}
Box b1 = new Box(); // b1 references a new Box object
Box b2 = b1; // b2 references the same object as b1
```

## Function Overloading

Multiple functions in a class with the same name but different parameters (different type or number of parameters).
Method overloading supports polymorphism.
The value of overloading is that it allows related methods to be accessed by use of a common name.

### Example:
```java
public class MathUtils {
    // Function to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded function to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded function to add two double values
    public double add(double a, double b) {
        return a + b;
    }
}
```

Overloaded functions must atleast differ in the type, number, or order of parameters they accept.

## Function Overriding

When a subclass provides a specific implementation of a method that is already defined in its superclass.

When an overridden method is called from within its subclass, it will always refer to the version of that method defined by the subclass.

Method overriding occurs only when the names and the type signatures of the two methods are identical. If they are not, then the methods are simply overloaded.

### Dynamic Method Dispatch

Dynamic method dispatch is the mechanism by which a call to an overriddden method is resolved at runtime, rather than compile time.

When an overridden method is called through a superclass reference, Java determines which version of the method to execute based on the actual object type (the type of the object being referred to), not the reference type (the type of the reference variable).
This allows java to implement runtime polymorphism.

When an overridden method is called through a superclass reference, Java determines which version of that method to execute based upon the type of the object being referred to at the time the call occurs. Thus, this determination is made at runtime.
When different types of objects are referred to, different versions of an overridden method will be called.

If a superclass contains a method that is overridden by a subclass, then when different types of objects are referred to through a superclass reference variable, different versions of the method are executed.


### Example:
```java
public class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
```

## Call by Value vs Call by Reference

In general, there are two ways that a computer language can pass an argument to a subroutine (function or method).

### Call By Value

This approach copies the value of an argument into the formal parameter of the function (subroutine).
Therefore changes made to the parameter inside the function have no effect on the argument.

```java
class Test {
    void meth(int i, int j) {
        i *= 2;
        j /= 2;
    }
}

class CallByValue {
    public static void main(String args[]) {
        Test ob = new Test();
        int a = 15, b = 20;
       System.out.println("a: " + a + " b: " + b); // a: 15 b: 20
        ob.meth(a, b);
        System.out.println("a: " + a + " b: " + b); // a: 15 b: 20
    }
}
```

### Call By Reference

When you pass an object to a method, the situation is different, because objects are passed by what is effectively call by reference.
When an object is passed to a method, the reference to that object is passed by value.

Keep in mind that when you create a variable of a class type, you are only creating a reference to an object.
Thus, when you pass this reference to a method, the parameter that receives it will refer to the same object as that referred to by the argument.

This effectively means that objects act as if they are passed to methods by use of call-by-reference.
Changes to the object inside the method do affect the object used as an argument.

```java
class Test{
    int a, b;
    Test(int i, int j){
        a = i;
        b = j;
    }
    
    // pass an object
   void meth(Test o){
        o.a *= 2;
        o.b /= 2;
    }
   
}

class CallByReference {
   public static void main(String[] args) {
      Test ob = new Test(15, 20);
     System.out.println("a: " + ob.a + " b: " + ob.b); // a: 15 b: 20
        ob.meth(ob);
        System.out.println("a: " + ob.a + " b: " + ob.b); // a: 30 b: 10
   }
}
```

## Recursion

Recursion is the process of calling the same function from which it has been invoked.

The compiler uses stack for implementing normal as well as recursive function calls.

A stack is a Last In First Out data structure.

When a function is called, a new block is created in the stack to hold the function's parameters and local variables.
When the function completes, its block is removed from the stack.

When a method calls itself, new local variables and parameters are allocated storage on the stack, and the method code is executed with these new variables from the start.
As each recursive call returns, the old local variables and parameters are removed from the stack, and execution resumes at the point of the call inside the method.

Recursive versions of routines may execute more slowly that the iterative equivalent because of the added overhead of the additional method calls. Many recursive calls to a method could cause a stack overrun.
Because storage for parameters ad local variables is on the stack and each new cell creates a new copy of these variables, it is possible that the stack could be exhausted.

## Garbage Collection

Java handles deallocation automatically.
Garbage collection only occurs sporadically (if at all) during the execution of your program. It will not occur simply because one or more objects exist that are no longer used.
Furthermore, different Java run-time implementations will take varying approaches to garbage collection, but for the most part, you should not have to think about it.

### finalize() method

By using finalization you can ensure that an object cleans up after itself before the object is discarded by the garbage collector.
The `finalize()` method is called by the garbage collector on an object when garbage collection determines that there are no more references to the object.
The garbage collector runs periodically checking for objects that are no longer referenced by any running state or indirectly through other reference objects.
Right befire an asset is freed, the Java run time calls the finalize() method on the object.

```java
protected void finalize() throws Throwable {
    try {
        // cleanup code
    } finally {
        super.finalize();
    }
}
```


# Object Oriented Programming

Object-oriented programming (OOP) is a programming paradigm that uses "objects" to design software. It is based on several key principles:

1. **Encapsulation**: Bundling data (attributes) and methods (functions) that operate on the data into a single unit called a class. This helps in restricting direct access to some of an object's components, which can prevent the accidental modification of data.
2. **Abstraction**: Hiding the complex implementation details and showing only the essential features of the object. This helps in reducing complexity and increases efficiency.
3. **Inheritance**: A mechanism where a new class (subclass) can inherit properties and behaviors (methods) from an existing class (superclass). This promotes code reusability and establishes a hierarchical relationship between classes.
4. **Polymorphism**: The ability of different classes to be treated as instances of the same class through a common interface. It allows methods to do different things based on the object it is acting upon, even though they share the same name.
5. **Classes and Objects**: A class is a blueprint for creating objects. An object is an instance of a class that contains data and methods to manipulate that data.
6. **Message Passing**: Objects communicate with each other through methods. This interaction is known as message passing, where one object sends a message to another object to invoke a method.
7. **Constructors and Destructors**: Constructors are special methods used to initialize objects when they are created. Destructors are used to clean up resources when an object is no longer needed (though Java uses garbage collection for memory management).
8. **Interfaces and Abstract Classes**: Interfaces define a contract that classes can implement, while abstract classes can provide some implementation but cannot be instantiated on their own. Both are used to achieve abstraction and polymorphism.
9. **Overloading and Overriding**: Overloading allows multiple methods with the same name but different parameters within the same class. Overriding allows a subclass to provide a specific implementation of a method already defined in its superclass.
10. **Composition and Aggregation**: These are design principles used to establish relationships between classes. Composition implies a strong ownership where the child cannot exist without the parent, while aggregation implies a weaker relationship where the child can exist independently of the parent.
11. **Access Modifiers**: Keywords that define the visibility of classes, methods, and variables. Common access modifiers include public, private, protected, and default (package-private).
12. **Design Patterns**: Reusable solutions to common problems in software design. Examples include Singleton, Factory, Observer, and Strategy patterns.
13. **SOLID Principles**: A set of five design principles aimed at making software designs more understandable, flexible, and maintainable. They include Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion principles.

### Constructors

In Java, when a subclass is instantiated, the constructor of its superclass is called first. This ensures that the superclass is properly initialized before the subclass adds its own initialization.

If a derived class has a constructor with same number of parameters as base class, then we need to call the base class constructor using `super()` keyword.
Or else, the default constructor ( zero argument constructor) of the base class is called automatically.

Constructors look a little strange because they have no return type, not even void, this is because the implicit return type of a class' constructor is the class type itself.
It is the constructor's job to initialize the internal state of an object so that the code creating an instance will have a fully initialized, usable object immediately.

When you do not explicitly define a constructor for a class, Java provides a default no-argument constructor that initializes the object with default values for all instance variables.
Once you define your own constructor, the default constructor is no longer used.

### this keyword

`this` can be used to refer to the current instance of a class. It is commonly used in the following scenarios:

1. **Distinguishing Instance Variables from Parameters**: When the names of instance variables and method parameters are the same, `this` is used to refer to the instance variable.
   ```java
   public class Person {
       private String name;

       public Person(String name) {
           this.name = name; // 'this.name' refers to the instance variable
       }
   }
   ```
2. **Calling Other Constructors**: `this()` can be used to call another constructor in the same class. This is useful for constructor chaining.
   ```java
    public class Rectangle {
         private int width;
         private int height;
    
         public Rectangle() {
              this(1, 1); // Calls the parameterized constructor with default values
         }
    
         public Rectangle(int width, int height) {
              this.width = width;
              this.height = height;
         }
    }
    ```

When a local variable has the same name as an instance variable, the local variable hides the instance variable.

`this` lets you refer directly to the object, you can use it to resolve any namespace collisions that might occur between instance variables and local variables.


### final keyword

In Java, the `final` keyword is used to define constants, prevent method overriding, and prevent inheritance of classes. Here are the different uses of the `final` keyword:
1. **Final Variables**: When a variable is declared as `final`, its value cannot be changed once it has been assigned. This is often used to define constants.
   ```java
   final int MAX_VALUE = 100;
   ```
2. **Final Methods**: When a method is declared as `final`, it cannot be overridden by subclasses. This is useful when you want to ensure that the implementation of a method remains unchanged.
   ```java
    public final void display() {
         System.out.println("This method cannot be overridden.");
    }
   ```
3. **Final Classes**: When a class is declared as `final`, it cannot be subclassed. This is useful when you want to prevent inheritance for security or design reasons.
    ```java
    public final class Utility {
         // Class implementation
    }
    ```


### abstract keyword

In Java, the `abstract` keyword is used to define abstract classes and abstract methods. Here are the different uses of the `abstract` keyword:
1. **Abstract Classes**: An abstract class is a class that cannot be instantiated on its own and is meant to be subclassed. It can contain both abstract methods (without implementation) and concrete methods (with implementation).
   ```java
   public abstract class Animal {
       // Abstract method (no implementation)
       public abstract void makeSound();
       
       // Concrete method (with implementation)
       public void eat() {
           System.out.println("This animal eats food.");
       }
   }
   ```
2. **Abstract Methods**: An abstract method is a method that is declared without an implementation. Subclasses of the abstract class must provide an implementation for all abstract methods.
   ```java
    public abstract void makeSound();
    ```
   

### static keyword

It is possible to create a member that can be used by itself, without reference to a specific instance. To create such a member, precede its declaration with the keyword `static`.

When a member is declared static, it can be accessed before any objects of tis class are created, and without reference to any object.

main() is declared static because it must be called before any objects exist.

Methods declared as static have following limitations:

- They can only directly call other static methods.
- They can only directly access static data.
- They cannot refer to "this" or "super" in any way.

As soon as class with static elements are loaded, all of the static statements are run.

### Varargs

In Java, varargs (variable-length arguments) allow a method to accept zero or more arguments of a specified type. This feature is useful when you want to create methods that can handle a varying number of parameters without having to overload the method multiple times.
To declare a varargs parameter, you use an ellipsis (`...`) after the data type in the method's parameter list. The varargs parameter must be the last parameter in the method signature.
```java
public class VarargsExample {
    // Method that accepts variable number of integer arguments
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3)); // Output: 6
        System.out.println(sum(10, 20));   // Output: 30
        System.out.println(sum());          // Output: 0
    }
}
```

The variable length parameter must be the last parameter declared by the method.
Methods with variable-length argument can be overloaded.

## Encapsulation

Encapsulation is one of the fundamental principles of object-oriented programming (OOP). It refers to the bundling of data (attributes) and methods (functions) that operate on that data into a single unit, typically a class. Encapsulation helps to restrict direct access to some of an object's components, which can prevent the accidental modification of data and promote modularity and maintainability in code.
It links data with the code that manipulates it.
Through encapsulation, you can control what parts of a program can access the members of a class.

This is achieved through access modifiers.

The four access levels are:
- **Public**: The member is accessible from any other class.
- **Protected**: The member is accessible within its own package and by subclasses. (Applied only when inheritance is involved)
- **Default (Package-Private)**: The member is accessible only within its own package. This is the default access level if no access modifier is specified.
- **Private**: The member is accessible only within its own class.

```java
public class Person {
    // Private attributes
    private String name;
    private int age;

    // Public constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Public getter for name
    public String getName() {
        return name;
    }

    // Public setter for name
    public void setName(String name) {
        this.name = name;
    }
}
```

## Inheritance

Inheritance is a fundamental concept in object-oriented programming (OOP) that allows a new class (called a subclass or derived class) to inherit properties and behaviors (attributes and methods) from an existing class (called a superclass or base class). This promotes code reusability and establishes a hierarchical relationship between classes.
### Example:
```java
// Superclass
public class Animal {
    public void eat() {
        System.out.println("This animal eats food.");
    }
}
// Subclass
public class Dog extends Animal {
    public void bark() {
        System.out.println("The dog barks.");
    }
}
// Main class
public class InheritanceExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(); // Inherited method from Animal class
        dog.bark(); // Method from Dog class
    }
}
```

Java doesnot support the inheritance of multiple superclasses into a single subclass.
A class member that has been declared as private will remain private to its class. It is not accessible by any code outside its class, including subclass.
A reference variable of a superclass can be assigned a reference to any subclass derived from that superclass.

### Types of Inheritance
1. **Single Inheritance**: A subclass inherits from a single superclass.
2. **Multilevel Inheritance**: A subclass inherits from a superclass, and another subclass inherits from that subclass.
3. **Hierarchical Inheritance**: Multiple subclasses inherit from a single superclass.
4. **Hybrid Inheritance**: A combination of two or more types of inheritance. (Not directly supported in Java due to lack of multiple inheritance for classes, but can be achieved using interfaces)
5. **Interface Inheritance**: A class can implement multiple interfaces, allowing for a form of multiple inheritance.
6. **Constructor Chaining**: In multilevel inheritance, constructors of superclasses are called in a chain when a subclass object is created.

### super keyword

`super` has two general forms. The first calls the superclass constructor. The second is used to access a member of the superclass that has been hidden by a member of a subclass.

A subclass can call a constructor defined by its superclass by use of the following form of super:
The second form of super allows a subclass to access a member of its superclass that has been hidden by a member of the subclass.

`super(arglist);`
`super.member`

`super()` must always be the first statement executed inside a subclass constructor.
In a class hierarchy, constructors complete their execution in order of derivation, from superclass to subclass.

If super() is not used then the default or parameterless constructor of each class will be executed.


## Polymorphism

As stated earlier, overridden methods allow Java to support run-time polymorphism.

Polymorphism is essential to object oriented programming for one reason: it allows a general class to specify 
methods that will be common to all of its derivatives, while allowing subclasses to define the specific implementation of some or all of those methods.

You can require that certain methods be overridden by subclasses by specifying the abstract type modifier.
These methods are sometimes referred as subclasser responsibility, because they have no implementation specified in the superclass.
A subclass must override them - it cannot simply use the version defined in the superclass.

Any class that declares one or more abstract method must also be declared abstract. To declare a class abstract, you simply use the abstract keyword in front of the class keyword at the beginning of class declaration.
There can be no objects of an abstract class, i.e. an abstract class cannot be directly instantiated with the new operator. Such objects would be useless, because an abstract class is not fully defined.

You cannot declare abstract constructors, or abstract static methods. Any subclass of an abstract class must either implement all of the abstract methods in the superclass, or be declared abstract itself.
### Example:
```java
// Abstract superclass
public abstract class Shape {
    // Abstract method (no implementation)
    public abstract double area();
}
// Subclass Circle
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementing the abstract method
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
// Subclass Rectangle
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Implementing the abstract method
    @Override
    public double area() {
        return width * height;
    }
}
// Main class
public class PolymorphismExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        System.out.println("Area of Circle: " + circle.area());
        System.out.println("Area of Rectangle: " + rectangle.area());
    }
}
```

Although abstract classes cannot be used to instantiate objects, they can be used to create object references, because Java's approach to run-time polymorphism is implemented through the use of superclass references. Thus, it must be possible to create a reference to an abstract class so that it can be used to point to a subclass object.

```java
// Using abstract methods and classes
abstract class Figure {
    double dim1;
    double dim2;
    
    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    
    // abstract method
   abstract double area();
}

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }
    
    // override area for rectangle
   double area() {
        System.out.println("Inside Area for Rectangle.");
        return dim1 * dim2;
   }
}

class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }
    
    // override area for right triangle
   double area() {
        System.out.println("Inside area of triangle");
        return dim1 * dim2 / 2;
   }
}

class AbstractAreas {
   public static void main(String[] args) {
      // Figure f = new Figure(10, 10); // Error! Cannot instantiate abstract class
      Rectangle r = new Rectangle(9, 5);
      Triangle t = new Triangle(10, 8);
      Figure figRef; // this is OK, no object is created
      
      figRef = r;
        System.out.println("Area is " + figRef.area());
        figRef = t;
        System.out.println("Area is " + figRef.area());
   }
}
```

To disallow a method from being overridden specify final as a modifier at the start of its declaration. Methods declared as final cannot be overridden.

Methods declared as final can sometimes provide a performance enhancement: The compiler is free to inline calls to them because it "knows" they will not be overridden by a subclass.

Java compiler can copy the bytecode for the subroutine directly inline with the compiled code of the calling method, thus elimianting the costly overhead associated with a method call. Inlining is an option only with final methods.

Normally, Java resolves calls to methods dynamically, at run time. This is called late binding. However, since final methods cannot be overridden, a call to one can be resolved at compile time. This is called early binding.

Declaring a class as final implicitly declares all of its methods as final too. It is illegal to declare a class as both abstract and final since an abstract class is incomplete by itself and relies upon its subclasses to provide complete implementations.

All classes in Java are subclasses of Object.

A class can implement more than one interface but can only inherit a single superclass.

## Packages and Interfaces

A package is oth a naming and a visibility control mechanism. You can define classes insde a package that are not accessible by code outside the package.
To create a package, use the package keyword as the first statement in a source file, followed by the name of the package.

```java
package com.example.myapp;
public class MyClass {
    // class implementation
}
```

The package statement defines a name space in which classes are stored.If you omit the package statement, the class names are put into the default package, which has no name.

Java use file system directories to store packages. For example, the .class files for any classes you declare to be part of `MyPackage` must be stored in a directory called MyPackage. Remember that case is significant, and the directory name must match the package name exactly.

```java
package pkg1.pkg2.pkg3;
```

A package hierarchy must be reflected in the file system of your Java development system. For example, if you declare a package named pkg1.pkg2.pkg3, then the source file for any class in that package must be stored in a directory named pkg3, which is contained inside a directory named pkg2, which is contained inside a directory named pkg1.

You cannot rename a package without renaming the directory in which the classes are stored.

By default, the java run time system uses the current working directory as its starting point. Thus, if your package is ina subdirectory of the current directory, it will be found.

You can specify a directory path or paths by setting `CLASSPATH` environment variable.

You can use the `-classpath` option with java and javac to specify the path to your classes.

```java
package MyPack;
```

In order for a program to find MyPack, one of the three things must be true. Either the program can be executed from a directory immediately above MyPack, or the CLASSPATH must be set to include the path to MyPack, or the -classpath option must specify the path to MyPack when the program is run via java.

When the second two options are used, the class path must not include MyPack, itself. It must simply specify the path to MyPack.

### Access Protection

Classes and packages are both means of encapsulating and containing the namespace and scope of variables and methods. 
Packages act as containers for classes and other subordinate packages. Classes act as containers for data and code. The class is Java's smallest unit of abstraction.

Because of the interplay between classes and packages, Java provides a four-tiered scheme for access protection. This scheme is implemented through the use of access modifiers.

- Subclasses in the same package
- Non-subclasses in the same package
- Subclasses in different packages
- Non-subclasses in different packages
The four access levels are:
- **Public**: The member is accessible from any other class.
- **Protected**: The member is accessible within its own package and by subclasses. (Applied only when inheritance is involved)
- **Default (Package-Private)**: The member is accessible only within its own package. This is the default access level if no access modifier is specified.
- **Private**: The member is accessible only within its own class.

When a class is public. it must be the only public class declared in the file, and the file must have the same name as the class.

Instead of import statement you can also use the fully qualifier name of the class whereever applicable.

### Interfaces

Using the keyword `interface`, you can fully abstract a class' interface from its implementation, i.e. using interface, you can specify what a class must do.

Interfaces are syntactically similar to classes, but they lack instance variables and concrete methods (methods with implementation).

- All methods in an interface are implicitly public and abstract (except static and default methods).
- All variables in an interface are implicitly public, static, and final (constants).
- Interfaces cannot be instantiated directly.
- A class can implement multiple interfaces, allowing for a form of multiple inheritance.
- Interfaces can extend other interfaces.
- Interfaces are used to achieve abstraction and polymorphism.
- Interfaces define a contract that implementing classes must adhere to.

Interfaces are designed to support dynamic method resolution at run time.

Normally, in order for a method to be called from one class to another, both classes need to be present at compile time so the Java compiler can check to ensure that the method signatures are compatible.
This requirement by itself makes for a static and nonextensible classing environment.
Interfaces are designed to solve for this problem. They disconnect the definition of a method or set of methods from the inheritance hierarchy.
Since interfaces are in adifferent hierarchy from classes, it is possible for classes that are unrelated in terms of the class hierarchy to implement the same interface.

```java
// Define an interface
public interface Animal {
    void makeSound(); // Abstract method
}
// Implement the interface in a class
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
// Implement the interface in another class
public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}
// Main class
public class InterfaceExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound(); // Output: Dog barks
        cat.makeSound(); // Output: Cat meows
    }
}
```
When no access modifier is inclued, then default access results, and the interface is only available to other members of the package in which it is declared.

A public interface must be the only interface declared in the file and the file must have the same name as the interface.

It is possible to add a default implementation to an interface method.

```java
public interface MyInterface {
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }
}
```

When a class implements an interface, it must provide concrete implementations for all of the interface's methods unless the class is declared abstract.

Variables can be declared inside of interface declarations. Such variables are implicitly public, static, and final.
All methods and variables are implicitly public.

You can declare variables as object references that use an interface rather than a class type.
Any instance of any class that implements the declared interface can be referred to by such a variable.
An interface reference variable has knowledge only of the methods declared by its interface declaration.

```java

public interface Animal {
   void makeSound(); // Abstract method
}
public class Dog implements Animal {
   @Override
   public void makeSound() {
       System.out.println("Dog barks");
   }
}
Animal myAnimal = new Dog(); // Dog implements Animal interface
myAnimal.makeSound(); // Calls Dog's implementation
```

If a class includes an interface but does not fully implement the methods required by that interface, then that class must be declared as `abstract`.

An interface can be declared a member of a class or another interface (nested interface).
A nested interface can be declared as public, private, or protected. Top of level interfaces can either be public or default.

You can use interfaces to import shared constants into multiple classes by simply declaring an interface that contains variables that are initialized to the desired values.
It is as if that class were importing the constant fields into the class name space as final variables.

One interface can inherit another by the use of `extends` keyword.
When a class implements an interface that inherits another interface, it must provide implementations for all methods required by the interface inheritance chain.

A key difference between class and interface is - a class can maintain state information but an interface cannot.

In all cases, a class implementation takes priority over an interface default implementation.
In cases where a class implements two interfaces that both have the same default method, but the class does not override that method, then an error will result.

It is possible to explicitly refer to a default implementation in an inherited interface by using a new form of `super`

`InterfaceName.super.methodName()`

Like static methods in a class, a static method defined by an interface can be called independently of any object.
```java
public interface MyInterface {
    static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }
}
MyInterface.staticMethod(); // Calling the static method
```

## Exception Handling

A Java exception is an object that decribes an exceptional (i.e. error) condition that has occurred in a piece of code.

When an exceptional condition arises, an exception object is created and thrown. Throwing an exception transfers control to an exception handler.
Exceptions can be generated by Java run-time system, or they can be manually generated by your code.

All exception types are subclasses of the built-in class Throwable.

Any exception that is not caught by your program will ultimately be processed by the default handler.

The stack trace will always show the sequence of method invocations that led up to the error.

A try catch block can have multiple catch blocks along with finally

```java
try {
    // code that may throw an exception
} catch (ExceptionType1 e1) {
    // handle ExceptionType1
} catch (ExceptionType2 e2) {
    // handle ExceptionType2
} finally {
    // code that will always execute
}
```

When you use multiple catch statements, it is important to remember that exception subclasses must come before any of their superclasses. This is because a catch statement that uses a superclass will catch exceptions of that type plus any of its suclasses.
Thus, a subclass would never be reached if it came after its superclass. Further, in Java, unreachable code is an error.

Try catch blocks can be nested.

Using `throw` statement, a java program can throw an exception explicitly.

`throw ThrowableInstance`

ThrowableInstance must be an object of type Throwable or a sub class of throwable.

There are two ways you can obtain a Throwable object: using a parameter in a catch clause or creating one with the new operator.

If a method is capable of causing an exception that it does not handle, it must specify this behaviour so that callers of the method can guard themselves against that exception.
This can be achieved by using `throws` clause in the method declaration.

`returnType methodName(parameters) throws ExceptionType1, ExceptionType2 { // method body }`

If a method does not handle a checked exception that it might generate, it must declare that exception using a throws clause.
If a method calls another method that declares a checked exception, then the calling method must either handle that exception or declare it in its own throws clause.

### Creating your won Exception subclasses

You can create your own exception subclasses by extending the Exception class (or any of its subclasses).

```java
// Custom exception class
public class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}
// Method that throws the custom exception
public void myMethod() throws MyCustomException {
    // Some code
    if (/* some condition */) {
        throw new MyCustomException("This is a custom exception message.");
    }
}
// Handling the custom exception
try {
    myMethod();
} catch (MyCustomException e) {
    System.out.println("Caught custom exception: " + e.getMessage());
}
```

When creating your own exception classes, it is a good practice to provide multiple constructors to allow for different ways of instantiating the exception, such as with a message, with a cause, or with both.

```java
public class MyCustomException extends Exception {
    public MyCustomException() {
        super();
    }

    public MyCustomException(String message) {
        super(message);
    }

    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCustomException(Throwable cause) {
        super(cause);
    }
}
```

Exception is a subclass of throwable.

### Chained Exceptions

Chained exceptions are a way to associate one exception with another, providing more context about the error that occurred. This is particularly useful when an exception is caused by another underlying exception.
Chained exceptions can be created by passing the original exception as a cause when throwing a new exception. This allows you to preserve the original exception information while providing additional context in the new exception.

```java
try {
    // Some code that may throw an exception
} catch (IOException e) {
    throw new MyCustomException("Failed to read file", e);
}
```

## Enumeration

Enumeration (enum) is a special data type in Java that enables a variable to be a set of predefined constants. The variable must be equal to one of the values that have been predefined for it. Enums are used when you have a fixed set of related constants, such as days of the week, months of the year, directions, etc.
An enumeration is created using the enum keyword.
```java
public enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}
```
Each value is implicitly declared as a public, static final member of enum DAY.
You can use enums in your code as follows:
```java
public class EnumExample {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        switch (today) {
            case MONDAY:
                System.out.println("Today is Monday.");
                break;
            case TUESDAY:
                System.out.println("Today is Tuesday.");
                break;
            // Handle other cases
            default:
                System.out.println("It's another day.");
                break;
        }
    }
}
```
Enums can also have fields, methods, and constructors. Here's an example:
```java
public enum Day {
    SUNDAY("Weekend"),
    MONDAY("Weekday"),
    TUESDAY("Weekday"),
    WEDNESDAY("Weekday"),
    THURSDAY("Weekday"),
    FRIDAY("Weekday"),
    SATURDAY("Weekend");

    private String type;

    // Constructor
    Day(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
```

Two enumeration constants can be compared for equality by using the == relational operator.
All enumerations automatically contain two predefined methods: `values()` and `valueOf()`

`values()` method returns an array that contains a list of the enumeration constants.
`valueOf()` method returns the enumeration constant whose value corresponds to the string passed in str.

Java enumeration is basically a class type, each enumeration constant is an object of its enumeration type.
When you define a constructor for an enum, the constructor is called when each enumeration constant is created. 
Also, each enumeration constant has its own copy of any instance variables defined by the enumeration.

All enums only inherit java.lang.Enum

You can obtain a value that indicates an enumeration constant's position in the list of constants by calling ordinal().

```java
public enum Color {
    RED,
    GREEN,
    BLUE
}
public class EnumOrdinalExample {
    public static void main(String[] args) {
        Color myColor = Color.GREEN;
        System.out.println("The ordinal of " + myColor + " is: " + myColor.ordinal());
    }
}
```

Java provides type wrappers which are classes that encapsulate a primitive type within an object. The type wrappers are Double, Float, Long, Integer Short, Byte, Character, and Boolean.

### Autoboxing and Autounboxing

Autoboxing is the process by which a primitive type is automatically encapsulated (boxed) into its equivalent type wrapper whenever an object of that type is needed.
There is no need to explicitly construct an object.

Auto unboxing is the process by which the value of a boxed object is automatically extracted from a type wrapper when its value is needed.

Autoboxing makes working with Collections Framework much easier.
```java
Integer obj = 100; //autobox an int
int i = obj; // auto unboxing
int i = obj.byteValue(); // manually unbox as byte
```

## Annotations

Annotations provide metadata about the program but are not part of the program itself. Annotations have no direct effect on the operation of the code they annotate.
They can be used by the compiler and can also be made available at runtime for reflection.

All annotations consist solely of method declarations. However you don't provide bodies for these methods.

```java
public @interface MyAnnotation {
    String value();
    int number() default 0; // default value
}
@MyAnnotation(value = "Example", number = 5)
public class MyClass {
    // class implementation
}

```

An annotation cannot include an extends clause. However, all annotations types automatically extend the Annotation interface.

A retention policy determines at what point an annotation is discarded. Java defines three such policies, which are encapsulated within the `java.lang.Annotation.RetentionPolicy` enumeration.
They are `SOURCE, CLASS, and RUNTIME`

- **SOURCE**: Annotations are discarded by the compiler and are not included in the compiled class files.
- **CLASS**: Annotations are recorded in the class file by the compiler but are not retained by the Java Virtual Machine (JVM) at runtime. This is the default retention policy.
- **RUNTIME**: Annotations are recorded in the class file by the compiler and are retained by the JVM at runtime, so they can be read reflectively.

A retention policy is specified for an annotation by using one of Java's built in annotations: @Retention

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRuntimeAnnotation {
    String info();
}
```

### Reflection

Reflection is a powerful feature in Java that allows a program to inspect and manipulate the properties of classes, methods, fields, and other components at runtime. 
It provides the ability to analyze the structure of classes, create instances of classes, invoke methods, and access fields dynamically.

Although annotations are designed mostly for use by other development or deployment tools, if they specify a retention policy of `RUNTIME`, then they can be queried at run time by any Java program through the use of reflection.
Reflection is the feature that enables information about a class to be obtained at run time.

```java
import java.lang.reflect.Method;
```

The first step to using a reflection is to obtain a Class object that represents the class whose annotations you want to obtain (using `getClass()` method).

```java
MyClass obj = new MyClass();
Class<?> cls = obj.getClass();

final Class<?> getClass(); // returns the class object that represents the invoking object
```

Once you have a Class object, you can use its methods to retrieve information about the class, including its annotations.
```java
import java.lang.annotation.Annotation;
Annotation[] annotations = cls.getAnnotations();
for (Annotation annotation : annotations) {
    System.out.println(annotation);
}
```

```java
// Reflection Example

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str() default "TESTING";
    int val() default 9000;
}

class Meta {
    @MyAnno(str = "Example", val = 100)
    public void myMethod() {
        Meta ob = new Meta();
        
        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMethod", String.class, int.class);
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " +  anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method not found");
        }
    }

   public static void main(String[] args) {
      myMethod("test", 10); 
   }
}
```
### Marker Annotation

A marker annotation is an annotation that does not contain any elements (methods). It is used to mark a class, method, or field with a specific property or behavior without providing any additional information.

### Single Member Annotation

A single member annotation is an annotation that contains only one element (method). When using a single member annotation, you can omit the element name when providing a value for it.

```java
@Retention(RetentionPolicy.RUNTIME)
@interface SingleMemberAnnotation {
    String value();
}
@SingleMemberAnnotation("This is a single member annotation")
public class MyClass {
    // class implementation
}
```

### Type Annotation

Type annotations are annotations that can be applied to types, such as class types, interface types, and type parameters. They provide additional information about the type they annotate.

```java
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@interface NonNull {
}
public class MyClass {
    public void myMethod(@NonNull String param) {
        // method implementation
    }
}
```
### Built-in Annotations
Java provides several built-in annotations that are commonly used in Java programming. Some of the most important built-in annotations include:
- **@Override**: Indicates that a method is intended to override a method in a superclass. It helps catch errors at compile time if the method does not actually override any method.
- **@Deprecated**: Indicates that a method, class, or field is deprecated and should not be used. It serves as a warning to developers that the annotated element may be removed in future versions.
- **@SuppressWarnings**: Instructs the compiler to suppress specific warnings for the annotated element. It is often used to suppress warnings about unchecked operations or deprecated methods.
- **@FunctionalInterface**: Indicates that an interface is intended to be a functional interface, which means it has exactly one abstract method. This annotation helps ensure that the interface meets the requirements of a functional interface.
- **@SafeVarargs**: Indicates that a method with a variable number of arguments (varargs) does not perform unsafe operations on its varargs parameter. It helps suppress warnings about potential heap pollution.
- **@Retention**: Specifies how long annotations with the annotated type are to be retained. It can take values from the `RetentionPolicy` enum (SOURCE, CLASS, RUNTIME).
- and more.

### Repeating Annotations

Repeating annotations allow you to apply the same annotation multiple times to a single element (class, method, field, etc.). This feature is useful when you want to provide multiple pieces of metadata of the same type.
To create a repeating annotation, you need to define a container annotation that holds an array of the repeating annotation type. Then, you can use the `@Repeatable` meta-annotation to specify the container annotation for the repeating annotation.

```java
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Hints {
    Hint[] value();
}
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Hints.class)
@interface Hint {
    String value();
}
@Hint("hint1")
@Hint("hint2")
public class MyClass {
    // class implementation
}
```

## Java I/O

Java programs perform I/O through streams. 
A stream is an abstraction that either produces or consumes information.
A stream is linked to a physical device by the Java I/O system.

Java defines two types of stream: byte and character.

Byte streams provide a convenient means for handling input and output of bytes. 
Byte streams are used for example, when reading or writing binary data.

Character streams provide a convenient means for handling input and output of characters.
They use unicode and, therefore, can be internationalized.
In some cases, character streams are more efficient than byte streams.

At the lowest level, all I/O is still byte-oriented.

### ByteStream Classes

Byte streams are defined by using two class hierarchies. At the top are two abstract classes: InputStream and OutputStream.

### Character Stream Classes

Character streams are defined using two class hierarchies. At the top are two abstract classes: Reader and Writer.

The try will resource statements can be used only with those resources that implement the AutoCloseable interface.


## transient and volatile Modifiers

When an instance variable is declared `transient`, then its value need not persist when an object is stored.

The `volatile` modifier tells the compiler that the variable modified by volatile can be changed unexpectedly by other parts of the program.

```java
public class SharedResource {
    private volatile int sharedCounter = 0;

    public void increment() {
        sharedCounter++;
    }

    public int getCounter() {
        return sharedCounter;
    }
}
```

## instanceof

The `instanceof` operator in Java is used to test whether an object is an instance of a specific class or implements a specific interface. It returns a boolean value: `true` if the object is an instance of the specified type, and `false` otherwise.
```java
if (object instanceof ClassName) {
    // code to execute if object is an instance of ClassName
}
```

You can enable or disable `assert` keyword using the -ea or -da flag.

## static imports

Static import allows members (fields and methods) which are declared as public static, to be used in Java code without specifying the class in which the field is defined.
```java
import static java.lang.Math.*; // Import all static members of Math class
public class StaticImportExample {
    public static void main(String[] args) {
        double result = sqrt(16); // No need to specify Math.sqrt
        System.out.println("Square root of 16 is: " + result);
    }
}
```

When using static import, it is possible to refer to static members directly by their names without qualifying them with the class name.

As convenient as static import can be, it is important not to abuse it. Remember, the reason that Java organizes its libraries into packages is to avoid namespace collisions.
When you import static members, you are bringing those members into the global namespace.
Thus, you are increasing the potential for namespace conflicts and for the inadvertent hiding of other names.
If you are using static member once or twice in your program, its best not to import it.
## Java Memory Model
The Java Memory Model (JMM) defines how threads in a Java program interact through memory and how changes made by one thread are visible to other threads. It provides a framework for understanding the behavior of concurrent programs and ensures that they operate correctly in a multi-threaded environment.
### Key Concepts of the Java Memory Model
1. **Threads and Shared Memory**: In Java, multiple threads can access shared memory concurrently. The JMM defines how these threads interact with memory and how changes made by one thread are visible to others.
2. **Happens-Before Relationship**: The JMM establishes a "happens-before" relationship between actions in different threads. If one action happens-before another, then the first action's effects are visible to the second action. This relationship is crucial for ensuring proper synchronization between threads.
3. **Volatile Variables**: The `volatile` keyword in Java is used to declare variables that can be accessed by multiple threads. When a variable is declared as volatile, it ensures that reads and writes to that variable are directly from and to the main memory, making changes visible to all threads immediately.
4. **Synchronization**: The JMM provides rules for synchronization using synchronized blocks or methods. When a thread enters a synchronized block, it acquires a lock on the object, ensuring exclusive access to the block. This prevents other threads from entering the same block until the lock is released.
5. **Atomicity**: The JMM guarantees that certain operations, such as reading or writing a single variable, are atomic. This means that these operations are indivisible and cannot be interrupted by other threads.
6. **Final Fields**: The JMM provides special guarantees for final fields. Once a final field is initialized, its value cannot be changed, and it is guaranteed to be visible to other threads after the constructor completes.

## Invoking constructors through this

When working with overloaded constructors, it is sometimes useful for one constructor to invoke another. In Java, this is accomplished by using another form of `this` keyword.

`this(arglist);`

## Optional Class

The `Optional` class in Java is a container object that may or may not contain a non-null value. It is used to represent the presence or absence of a value, helping to avoid null pointer exceptions and making code more readable and expressive.
```java
import java.util.Optional;
public class OptionalExample {
    public static void main(String[] args) {
        // Creating an Optional with a non-null value
        Optional<String> optionalValue = Optional.of("Hello, World!");

        // Checking if the value is present
        if (optionalValue.isPresent()) {
            System.out.println("Value: " + optionalValue.get());
        }

        // Creating an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // Using orElse to provide a default value
        String defaultValue = emptyOptional.orElse("Default Value");
        System.out.println("Value: " + defaultValue);
    }
}
```

## Observable Class

The `Observable` class in Java is part of the `java.util` package and is used to implement the Observer design pattern. It represents an object that can be observed by other objects (observers). When the state of the observable object changes, it notifies all registered observers about the change.
```java
import java.util.Observable;
import java.util.Observer;
// Observable class
class NewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged(); // Mark the observable as changed
        notifyObservers(news); // Notify all observers
    }
}
// Observer class
class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " received news update: " + arg);
    }
}
// Main class
public class ObserverExample {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsChannel channel1 = new NewsChannel("Channel 1");
        NewsChannel channel2 = new NewsChannel("Channel 2");

        agency.addObserver(channel1);
        agency.addObserver(channel2);

        agency.setNews("Breaking News: Java Observer Pattern in Action!");
    }
}
```

## Timer and TimerTask

The `Timer` class in Java is used to schedule tasks for future execution in a background thread. It allows you to schedule tasks to be executed once or repeatedly at fixed intervals. The tasks to be executed are defined by extending the `TimerTask` class.
```java
import java.util.Timer;
import java.util.TimerTask;
public class TimerExample {
    public static void main(String[] args) {
        Timer timer = new Timer();

        // Schedule a task to run after a delay of 2 seconds
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task executed after 2 seconds");
            }
        }, 2000);

        // Schedule a task to run every 3 seconds
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Repeating task executed");
            }
        }, 0, 3000);
    }
}
```

In this example, we create a `Timer` object and schedule two tasks. The first task is scheduled to run once after a delay of 2 seconds, while the second task is scheduled to run repeatedly every 3 seconds. Each task is defined by extending the `TimerTask` class and overriding the `run()` method to specify the code to be executed when the task is triggered.
```java
import java.util.Timer;
import java.util.TimerTask;
class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Timer task executed");
    }
}
public class TimerTaskExample {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimerTask task = new MyTimerTask();

        // Schedule the task to run after a delay of 1 second
        timer.schedule(task, 1000);
    }
}
```

## ResourceBundle, ListResourceBundle, and PropertyResourceBundle Classes

The `ResourceBundle` class in Java is used for internationalization (i18n) and localization (l10n) of applications. It allows you to manage and retrieve locale-specific resources, such as strings, images, and other data, based on the user's locale settings.
```java
import java.util.ResourceBundle;
public class ResourceBundleExample {
    public static void main(String[] args) {
        // Load the resource bundle for the default locale
        ResourceBundle bundle = ResourceBundle.getBundle("Messages");

        // Retrieve localized strings
        String greeting = bundle.getString("greeting");
        String farewell = bundle.getString("farewell");

        System.out.println(greeting);
        System.out.println(farewell);
    }
}
```

In this example, we load a resource bundle named "Messages" and retrieve localized strings for "greeting" and "farewell". The actual resource files (e.g., Messages_en.properties, Messages_fr.properties) would contain the localized strings for different locales.
```java
import java.util.ListResourceBundle;
public class MyResources_en extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][] {
            {"greeting", "Hello"},
            {"farewell", "Goodbye"}
        };
    }
}

public class MyResources_fr extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][] {
            {"greeting", "Bonjour"},
            {"farewell", "Au revoir"}
        };
    }
}
```

The java.util package includes three classes that aid in the internationalization of your program.
The ResourceBundle abstract class defines methods taht enable you to manage a collection of locale-sensitive resources.

A locale refers to a specific geograhical, cultural, or political region.
In Java, the locale class is used to encapsulate this information.

The ListResourceBundle class is a subclass of ResourceBundle that manages resources for a locale in the form of key-value pairs stored in an array.

## java.lang 

java.lang is automatically imported into all programs.

Primitive types like int and char cannot be directly passed by reference.
There is no way for two methods to refer to the same instance of an int.

Java provides classes that correspond to each of the primitive types. In essence, these classes  encapsulate, or wrap, the primitive types within a class.
Thus, they are commonly referred to as type wrappers.

### Number

The abstract class Number defines a superclass that is implemented by the classes that wrap the numeric types byte, short, int, long, float, and double.

Number has abstract methods that return the value of the object in each of the different number formats.

Number has concrete subclasses that hold explicit values of each primitive numeric type: Double, Float, Byte, Short, Integer, and Long.

Float and Double provide the methods isInfinite() and is Nan(), which help when manipulating two special double and float values.
These methods test for two unique values defined by the IEEE floating-point specification: infinity and NaN (not a number).
isInfinite() returns true if the value being tested is infinitely large or small in magnitude.
is NaN() returns true if the value being tested is not a number.

### Using clone() and the Cloneable Interface

The `clone()` method in Java is used to create a copy of an object. It is defined in the `Object` class and is protected by default, meaning it can only be accessed within the same package or by subclasses.
To use the `clone()` method, a class must implement the `Cloneable` interface, which is a marker interface (it does not contain any methods). Implementing this interface indicates that the class supports cloning.
```java
class MyClass implements Cloneable {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Call the Object's clone() method
    }

    public int getValue() {
        return value;
    }
}
public class CloneExample {
    public static void main(String[] args) {
        try {
            MyClass original = new MyClass(10);
            MyClass copy = (MyClass) original.clone(); // Clone the original object

            System.out.println("Original value: " + original.getValue());
            System.out.println("Cloned value: " + copy.getValue());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
```

Cloning is a potentially dangerous action, because it can cause unintended side effects.


### The Comparable Interface

The `Comparable` interface in Java is used to define the natural ordering of objects of a class. It contains a single method, `compareTo()`, which is used to compare the current object with another object of the same type. The `compareTo()` method returns an integer value that indicates the relative order of the two objects.
```java
class MyClass implements Comparable<MyClass> {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyClass other) {
        return Integer.compare(this.value, other.value);
    }

    public int getValue() {
        return value;
    }
}
public class ComparableExample {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass(10);
        MyClass obj2 = new MyClass(20);

        int result = obj1.compareTo(obj2);
        if (result < 0) {
            System.out.println("obj1 is less than obj2");
        } else if (result > 0) {
            System.out.println("obj1 is greater than obj2");
        } else {
            System.out.println("obj1 is equal to obj2");
        }
    }
}
```

Objects of classes the implement Comparable can be ordered.
The Comparable interface declares one method that is used to determine what Java calls the natural ordering of instances of a class.

`int compareTo(T obj)`

This method captures the invoking object with obj.
It returns 0 if the values are equal.
A negative value is returned if the invoking object has a lower value.
Otherwise, a positive value is returned.

### The Appendable Interface

The `Appendable` interface in Java is used to define a contract for classes that can append character sequences. It contains methods for appending characters, character sequences, and strings to an object. The `Appendable` interface is implemented by classes such as `StringBuilder`, `StringBuffer`, and `Writer`.

```java
public class AppendableExample {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            // Append a character
            stringBuilder.append('A');

            // Append a character sequence
            stringBuilder.append("BCDE");

            // Append a string
            stringBuilder.append("FGHIJ");

            System.out.println("Appended String: " + stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Objects of a class that implements Appendable can have a character or character sequences appended to it.

### The Iterable Interface

The `Iterable` interface in Java is used to define a contract for classes that can be iterated over. It contains a single method, `iterator()`, which returns an `Iterator` object that can be used to traverse the elements of the collection. The `Iterable` interface is implemented by classes such as `ArrayList`, `HashSet`, and `LinkedList`.

```java
import java.util.Iterator;
import java.util.ArrayList;
public class IterableExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Using the iterator to traverse the elements
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }
    }
}
```

Iterable must be implemented by any class whose objects will be used by the for-each version of the for loop.

In other words, in order for an object to be used within a for-each style for loop, its class must implement Iterable.

```java
for (Type var : iterableObject) {
    // Use var
}
```

### The Readable Interface

The `Readable` interface in Java is used to define a contract for classes that can read character data. It contains a single method, `read()`, which reads characters into a specified character buffer. The `Readable` interface is implemented by classes such as `Reader` and its subclasses.

### The AutoCloseable Interface

The `AutoCloseable` interface in Java is used to define a contract for classes that can be closed automatically when they are no longer needed. It contains a single method, `close()`, which is called to release resources held by the object. The `AutoCloseable` interface is implemented by classes such as `InputStream`, `OutputStream`, and `Connection`.

### Comparator Interface

The `Comparator` interface in Java is used to define a custom ordering for objects of a class. It contains two methods, `compare()` and `equals()`, which are used to compare two objects and determine their relative order. The `Comparator` interface is often used in conjunction with sorting algorithms and data structures that require ordering, such as `TreeSet` and `PriorityQueue`.
```java
import java.util.Comparator;
class MyComparator implements Comparator<MyClass> {
    @Override
    public int compare(MyClass obj1, MyClass obj2) {
        return Integer.compare(obj1.getValue(), obj2.getValue());
    }
}
public class ComparatorExample {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass(10);
        MyClass obj2 = new MyClass(20);

        MyComparator comparator = new MyComparator();
        int result = comparator.compare(obj1, obj2);

        if (result < 0) {
            System.out.println("obj1 is less than obj2");
        } else if (result > 0) {
            System.out.println("obj1 is greater than obj2");
        } else {
            System.out.println("obj1 is equal to obj2");
        }
    }
}
```

## Input/Output

### File Class

Although most of the classes defined by java.io operate on streams, the File class does not. 
It deals directly with files and the file system, i.e. the File class does not specify how information is retrieved from or stored in files; it describes the properties of a file itself.

A File object is used to obtain or manipulate the information associated with a disk file, such as the permissions, time, date, and directory path, and to navigate subdirectory hierarchies.

The following constructors can be used to create File objects

`File(String pathname)`
`File(String parent, String child)`
`File(File parent, String child)`
`File(URI uri)`

The File class provides methods for creating, deleting, and inspecting files and directories.

A directory is a File that contains a list of other files and directories.

There are three interfaces that are quite important to the stream class. Two are Closeable and Flushable, the third is AutoCloseable.

AutoCloseable provides support for the try-with-resources statement, which automates the process of closing a resource.

Only objects of classes that implement AutoCloseable can be managed by try-with-resources.

The AutoCloseable interface defines only the close() method.

```java
void close() throws Exception;
```

Because this interface is implemented by all of the I/O classes that open a stream, all such streams can be automatically closed by a try-with-resources statement.

Objects of a class that implements Flushable can force buffered output to be written to the stream to which the object is attached. It defines the flush() method.

Flushing a stream typically causes buffered output to be physically written to the underlying device. This interface is implemented by all of the I/O classes that write to a stream.

The principal advantage of try-with-resources is that the resource is closed automatically when the try block ends.

### The Stream Classes

Java's stream based I/O is build upon four abstract classes: 

- InputStream
- OutputStream
- Reader
- Writer

InputStream and OutputStream are designed for byte streams.
Reader and Writer are designed for character streams.

The byte stream classes provide a rich environment for handling byte-oriented I/O.
A byte stream can be used with any type of object, including binary data.

### InputStream

InputStream is an abstract class that defines Java's model of streaming byte input.
It implements the AutoCloseable and Closeable interfaces

### OutputStream

OutputStream is an abstract class that defines streaming byte output.
It implements the AutoCloseable, Closeable, and Flushable interfaces.
Most of the methods defined by this class return void and throw an IOException.

### FileInputStream

The FileInputStream class creates an InputStream that you can use to read bytes from a file.
Two commonly used constructors are:

`FileInputStream(String filename)`
`FileInputStream(File file)`

Either can throw a FileNotFoundException.

### FileOutputStream

The FileOutputStream class creates an OutputStream that you can use to write bytes to a file.
It implements AutoCloseable, Closeable, and Flushable interfaces.

Its commonly used constructors are:

`FileOutputStream(String filename)`
`FileOutputStream(File file)`
`FileOutputStream(String filename, boolean append)`
`FileOutputStream(File file, boolean append)`

Either can throw a FileNotFoundException.

Creation of a FileOutputStream is not dependent on the file already existing.

### ByteArrayInputStream

The ByteArrayInputStream class creates an InputStream that uses a byte array as its source.
Its commonly used constructors are:

`ByteArrayInputStream(byte[] buf)`
`ByteArrayInputStream(byte[] buf, int offset, int length)`

The close() method has no effect on a ByteArrayInputStream.

A ByteArrayInputStream implements both mark() and reset(). 
However if mark() has not been called then reset() sets the stream pointer to the start of the stream.

### ByteArrayOutputStream

The ByteArrayOutputStream class creates an OutputStream that uses a byte array as its destination.
Its commonly used constructors are:
`ByteArrayOutputStream()`
`ByteArrayOutputStream(int size)`

The buffer is held in the protected buf field of ByteArrayOutputStream.
The buffer size will be increased automatically, if needed.
The number of bytes held by the buffer is contained in the protected count field of ByteArrayOutputStream.

The close() method has no effect on a ByteArrayOutputStream.

### Filtered Byte Streams

Filtered streams are simply wrappers around underlying input or output streams that transparently provide some extended level of functionality.

### Buffered Byte Streams

A buffered stream extends a filtered stream class by attaching a memory buffer to the I/O stream.
This buffer allows Java to do I/O operations on more than a byte at a time, thereby improving performance.

### BufferedInputStream

The BufferedInputStream class creates a filtered input stream that adds functionality to another input stream-namely, the ability to buffer the input and to support the mark and reset methods.

Java's BufferedInputStream class allows you to "wrap" any InputStream into a buffered stream to improve performance.

BufferedInputStream has two constructors:

`BufferedInputStream(InputStream in)`
`BufferedInputStream(InputStream in, int size)`

An optimal buffer size is generally dependent on the host operating system, the amount of memory available, and how the machine is configured.
The default buffer size is 8192 bytes (8 KB).
Attaching even a rather small buffer to an I/O stream is always a good idea.
That way, the low-level system can read blocks of data from the disk or network and store the results in your buffer.

Buffering an input stream also provides the foundation required to support moving backward in the stream of the available buffer.
Beyond the read() and skip() methods implemented in any InputStream, BufferedInputStream also implements the mark() and reset() methods.

### BufferedOutputStream

The BufferedOutputStream class creates a filtered output stream that adds functionality to another output stream-namely, the ability to buffer the output and to support the flush method.

A BufferedOutputStream is similar to any OutputStream with the exception that the flush() method is used to ensure that data buffers are written to the stream being buffered.

Since the point of a BufferedOutputStream is to improve performance by reducing the number of times the system actually writes data, you may need to call flush() to cause any data that is in buffer to be immediately written.

Its commonly used constructors are:

`BufferedOutputStream(OutputStream out)`
`BufferedOutputStream(OutputStream out, int size)`

### PushbackInputStream

The PushbackInputStream class creates a filtered input stream that adds functionality to another input stream-namely, the ability to "push back" or "unread" one or more bytes.

Pushback is used on an input stream to allow a byte to be read and then returned to the stream.
The PushbackInputStream class is useful in situations where you need to read ahead in a stream to determine what to do next, but then need to return the read bytes back to the stream for further processing.

It provides a mechanism to peek at what is coming from an input stream without disrupting it.

Its commonly used constructors are:

`PushbackInputStream(InputStream in)`
`PushbackInputStream(InputStream in, int size)`

This class provides unread() methods that allow you to push back one or more bytes.

```java
void unread(int b) throws IOException;
void unread(byte[] b) throws IOException;
void unread(byte[] b, int off, int len) throws IOException;
```

The unread() methods throw an IOException if there is not enough room in the pushback buffer to accommodate the bytes being pushed back.

### SequenceInputStream

The SequenceInputStream class creates an input stream that concatenates multiple input streams into one.

Its commonly used constructors are:

`SequenceInputStream(InputStream s1, InputStream s2)`
`SequenceInputStream(Enumeration<? extends InputStream> e)`

The SequenceInputStream reads from the first input stream until the end of the stream is reached.
Then, it reads from the second input stream, and so on, until all input streams have been read.

### PrintStream

The PrintStream class is a filtered output stream that adds functionality to another output stream-namely, the ability to print representations of various data values conveniently.
PrintStream implements all of the print() and println() methods that are commonly used to display data.

Its commonly used constructors are:

`PrintStream(OutputStream out)`
`PrintStream(OutputStream out, boolean autoFlush)`
`PrintStream(OutputStream out, boolean autoFlush, String encoding)`

### DataOutputStream and DataInputStream

DataOutputStream and DataInputStream enable you to write or read primitive data to or from a stream.
They implement DataOutput and DataInput interfaces respectively.
DataOutputStream has methods for writing primitive data types to an output stream in a portable way.
DataInputStream has methods for reading primitive data types from an input stream in a portable way.

These streams make it easy to store binary data, such as integers or floating-point values, in a file.

DataInputStream is the complement of DataOutputStream.

### RandomAccessFile 

The RandomAccessFile class is used to read from and write to a file in a random access manner.
It allows you to move the file pointer to any position within the file and read or write data at that position.

### The Character Streams

While the byte stream provide sufficient functionality to handle any type of I/O operation, they cannot work directly with Unicode characters.

### Reader

Reader is an abstract class that defines Java's model of streaming character input.

### Writer

Writer is an abstract class that defines Java's model of streaming character output.

### FileReader

The FileReader class creates a Reader that you can use to read characters from a file.

Its commonly used constructors are:
`FileReader(String filename)`
`FileReader(File file)`

### FileWriter

The FileWriter class creates a Writer that you can use to write characters to a file.
Its commonly used constructors are:
`FileWriter(String filename)`
`FileWriter(File file)`
`FileWriter(String filename, boolean append)`
`FileWriter(File file, boolean append)`

### CharArrayReader

The CharArrayReader class creates a Reader that uses a character array as its source.

Its commonly used constructors are:
`CharArrayReader(char[] buf)`
`CharArrayReader(char[] buf, int offset, int length)`

### CharArrayWriter

The CharArrayWriter class creates a Writer that uses a character array as its destination.

Its commonly used constructors are:
`CharArrayWriter()`
`CharArrayWriter(int size)`

### BufferedReader

The BufferedReader class creates a filtered reader that adds functionality to another reader-namely, the ability to buffer the input and to support the mark and reset methods.

Its commonly used constructors are:

`BufferedReader(Reader in)`
`BufferedReader(Reader in, int size)`

As is the case with the byte-oriented stream, buffering an input character stream also provides the foundation required to support moving backward in the stream within the available buffer.

Beyond the read() and skip() methods implemented in any Reader, BufferedReader also implements the mark() and reset() methods.

### BufferedWriter

The BufferedWriter class creates a filtered writer that adds functionality to another writer-namely, the ability to buffer the output and to support the flush method.
Its commonly used constructors are:
`BufferedWriter(Writer out)`
`BufferedWriter(Writer out, int size)`

### PushbackReader

The PushbackReader class allows one or more characters to be returned to the input stream.

Its commonly used constructors are:

`PushbackReader(Reader in)`
`PushbackReader(Reader in, int size)`

Closing a PushbackReader also closes the underlying stream specified by inputStream.

PushbackReader provides unread(), which returns one or more characters to the invoking input stream.

### PrintWriter

The PrintWriter class is a filtered writer that adds functionality to another writer-namely, the ability to print representations of various data values conveniently.
Its commonly used constructors are:
`PrintWriter(Writer out)`
`PrintWriter(Writer out, boolean autoFlush)`
`PrintWriter(OutputStream out)`
`PrintWriter(OutputStream out, boolean autoFlush)`

## Serialization

Serialization is the process of writing the state of an object to a byte stream.

This is useful when you want to save the state of your program to a persistent storage area, such as a file.

Serialization is also needed to implement Remote Method Invocation (RMI).
RMI allows a Java object on one machine to invoke a method of a Java object on a different machine.
An object may be supplied as an argument to that remote method.

### Serializable Interface

Only an object that implements the Serializable interface can be saved and restored by the serialization facilities.

The Serializable interface defines no members.
It is simply used to indicate that a class may be serialized.
If a class is serializable, all of its subclasses are also serializable.

Variables that are declared as transient are not saved by the serialization facilities.
Also, static variables are not saved.

### Externalizable Interface

The Externalizable interface extends the Serializable interface and provides more control over the serialization process.
When a class implements the Externalizable interface, it must implement two methods: `writeExternal()` and `readExternal()`.

Java facilities that serialize an object of a class that implements Externalizable call these methods to save and restore the object's state.

### ObjectOutput Interface

The ObjectOutput interface extends the DataOutput interface and defines additional methods for writing objects to an output stream.

### ObjectInput Interface

The ObjectInput interface extends the DataInput interface and defines additional methods for reading objects from an input stream.

### ObjectOutputStream

The ObjectOutputStream class is used to write objects to an output stream.
It implements the ObjectOutput interface and provides methods for serializing objects.

### ObjectInputStream

The ObjectInputStream class is used to read objects from an input stream.
It implements the ObjectInput interface and provides methods for deserializing objects.

## Exploring NIO

Java NIO (New Input/Output) is a collection of Java programming language APIs that offer features for intensive I/O operations. It was introduced in JDK 1.4 and provides a more efficient way to handle I/O operations compared to the traditional Java I/O (java.io) package.
### Key Components of Java NIO

1. **Buffers**: Buffers are containers for data that is being transferred between a channel and an application. They provide a way to read and write data in a more efficient manner.
2. **Channels**: Channels are used to read and write data to and from buffers. They provide a connection to an I/O device, such as a file or a network socket.
3. **Selectors**: Selectors are used to monitor multiple channels for events, such as incoming data or connection requests. They allow a single thread to manage multiple channels, improving scalability and performance.
4. **Charsets**: Charsets are used to encode and decode character data. They provide a way to convert between different character encodings, such as UTF-8 and ISO-8859-1.


It supports buffer-oriented, channel-based approach to I/O operations.

The NIO system is built on two foundational items: buffers and channels.
A buffer holds data. A channel represents an open connection to an I/O device, such as a file or a socket.

In general, to use the NIO system, you obtain a channel to an I/O device and a buffer to hold daata.
You then operate on the buffer, inputting or outputting data as needed.

### Buffers

All buffers are subclasses of the Buffer class, which defines the core functionality common to all buffers: current position, limit, and capacity.

All buffers provide various get() and put() methods, which allow you to get data from a buffer or put data into a buffer.

### Channels

A channel represents an open connection to an I/O device, such as a file or a socket.

Channels can be used for reading, writing, or both.

### Charsets and Selectors

A charset defines the way that bytes are mapped to characters.
You can encode a sequence of characters into bytes using an encoder.
You can decode a sequence of bytes into characters using a decoder.

A selector supports key-based, non-blocking, multiplexed I/O.
Selectors enable you to perform I/O through multiple channels.
Selectors are most applicable to socket-backed channels.

### The Path Interface

The Path interface encapsulates a path in the file system.
A Path object can represent a file or a directory.

You can obtain a Path object by using the Paths.get() method or the File.toPath() method.

### The Files Class

The Files class provides static methods for file and directory operations.
You can use the Files class to create, delete, copy, move, and read files and directories.
You can also use the Files class to read and write file attributes, such as permissions and timestamps.

### The Paths Class

The Paths class provides static methods for creating Path objects.
You can use the Paths.get() method to create a Path object from a string representation of a path.
```java
import java.nio.file.Path;
import java.nio.file.Paths;
public class PathsExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:/example/directory/file.txt");
        System.out.println("Path: " + path.toString());
    }
}
```

An important use of NIO is to access a file via a channel and buffers.

### Reading a File via a Channel

```java
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class NIOFileReadExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.txt");
             FileChannel fileChannel = fis.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buffer);

            while (bytesRead != -1) {
                buffer.flip(); // Switch buffer from writing to reading

                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }

                buffer.clear(); // Clear buffer for the next read
                bytesRead = fileChannel.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Use NIO for Stream-Based I/O

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class NIOStreamExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt");
             FileChannel inputChannel = fis.getChannel();
             FileChannel outputChannel = fos.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = inputChannel.read(buffer);

            while (bytesRead != -1) {
                buffer.flip(); // Switch buffer from writing to reading
                outputChannel.write(buffer);
                buffer.clear(); // Clear buffer for the next read
                bytesRead = inputChannel.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Use NIO for Path and File System Operations

## Stream API

The stream API provides some of the most significant demonstrations of the power that lambdas being to Java.

Streams are sequences of elements that support various methods which can be pipelined to produce the desired result.

A stream is a conduit for data.
Thus, a stream represents a sequence of objects.

A stream itself never provides storage for the data.
It simply moves data, possibly filtering, sorting, or otherwise operating on that data in the process.

### Stream Interfaces

An I/O stream can act conceptually much like one of the streams defined by java.util.stream, they are not same.

The stream API defines several stream interfaces, which are packaged in java.util.stream.
At the foundation ins BaseStream, which defines functionality available in all streams.

Methods are notated either terminal or intermediate.

A terminal operation consumes the stream.
It is used to produce a result.

Once a stream has been consumed it cannot be reused.

Intermediate operations produce another stream.
Intermediate operations can be used to create a pipeline that performs a sequence of actions.

Intermediate operations do not take place immediately.
Instead, the specified action is performed when a terminal operation is executed on the new stream created by an intermediate operation.
This mechanism is referred to as lazy behaviour, and the intermediate operations are referred to as lazy.

The use of lazy intermediate operations can improve performance by eliminating unnecessary processing.

Some intermediate operations are stateless and some are stateul.

In stateless operation, each element is processed independently of the others.

In a stateful operation, the processing of an element may depend on aspects of other elements.
sorted() method is stateful.
filter() is stateless.


You can obtain a stream in a number of ways.
The Collection interface has been expanded to include two methods that obtain a stream from a collection

`Stream<T> stream()`
`Stream<T> parallelStream()`

The stream() method creates a sequential stream, whereas the parallelStream() method creates a parallel stream.

### Sample Stream Example

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Create a stream from the list of names
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A")) // Intermediate operation
                .map(String::toUpperCase) // Intermediate operation
                .collect(Collectors.toList()); // Terminal operation

        // Print the filtered names
        filteredNames.forEach(System.out::println);
    }
}
```

Because Collection is implemented by every collection class, stream() can be used to obtain stream for any type of collection.

### Using stream and Comparator

```java
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
public class StreamComparatorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Create a stream from the list of names and sort them
        names.stream()
                .sorted(Comparator.naturalOrder()) // Sort in natural order
                .forEach(System.out::println); // Terminal operation
    }
}
```

### Using stream with Optional

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class StreamOptionalExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Create a stream from the list of numbers and find the first even number
        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n % 2 == 0) // Intermediate operation
                .findFirst(); // Terminal operation

        // Print the first even number if present
        firstEven.ifPresent(System.out::println);
    }
}
```

### Using stream with custom comaprator

```java
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
public class StreamCustomComparatorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Create a stream from the list of names and sort them by length
        names.stream()
                .sorted(Comparator.comparingInt(String::length)) // Sort by length
                .forEach(System.out::println); // Terminal operation
    }
}
```

### Using stream and consumer

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
public class StreamConsumerExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Create a Consumer to print names
        Consumer<String> printName = name -> System.out.println("Name: " + name);

        // Create a stream from the list of names and use the Consumer
        names.stream()
                .forEach(printName); // Terminal operation
    }
}
```

### Using stream with filter

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {
    public static void main(String[] args) {
        // Create an ArrayList of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);

        // Use stream with filter to get numbers greater than 20
        List<Integer> filteredNumbers = numbers.stream()
                                               .filter(num -> num > 20) // Filter condition
                                               .collect(Collectors.toList()); // Collect the result

        // Print the filtered numbers
        System.out.println("Filtered Numbers: " + filteredNumbers);
    }
}
```

### Using stream and filtering with predicate

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFilterWithPredicateExample {
    public static void main(String[] args) {
        // Create an ArrayList of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);

        // Define a custom predicate to filter numbers greater than 20
        Predicate<Integer> isGreaterThan20 = num -> num > 20;

        // Use stream with the custom predicate to filter numbers
        List<Integer> filteredNumbers = numbers.stream()
                                               .filter(isGreaterThan20)
                                               .collect(Collectors.toList());

        // Print the filtered numbers
        System.out.println("Filtered Numbers: " + filteredNumbers);
    }
}
```

### Reduction Operations

```java
import java.util.Arrays;
import java.util.List; 
import java.util.Optional;
public class StreamReductionExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Use stream to calculate the sum of all numbers
        Optional<Integer> sum = numbers.stream()
                                       .reduce((a, b) -> a + b); // Reduction operation

        // Print the sum if present
        sum.ifPresent(result -> System.out.println("Sum: " + result));
    }
}
```

### Reduction operation with reduce

By using reduce(), you can return a value from a steam based on any arbitrary accumulation operation that you define.
```java
import java.util.Arrays;
import java.util.List;
public class StreamReductionWithIdentityExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Use stream to calculate the sum of all numbers with an identity value
        Integer sum = numbers.stream()
                             .reduce(0, (a, b) -> a + b); // Reduction operation with identity

        // Print the sum
        System.out.println("Sum: " + sum);
    }
}
```

It is important to understand that the accumulator operation must satisfy three constraints. 
It must be:
- Associative - the order in which operations are performed does not change the result.
- Stateless - the result of the operation depends only on the input parameters.
- Non-interfering - the operation does not modify the data source.

### BiFunction Example

```java
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class BiFunctionWithStreamsExample {
   public static void main(String[] args) {
      // Two lists of integers
      List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
      List<Integer> list2 = Arrays.asList(10, 20, 30, 40, 50);

      // Define a BiFunction to add two integers
      BiFunction<Integer, Integer, Integer> addFunction = (a, b) -> a + b;

      // Use streams to combine the two lists
      List<Integer> result = IntStream.range(0, Math.min(list1.size(), list2.size()))
              .mapToObj(i -> addFunction.apply(list1.get(i), list2.get(i)))
              .toList();

      // Print the result
      System.out.println("Resulting List: " + result);
   }
}
```

### Using Parallel Streams

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {
   public static void main(String[] args) {
      // Create a list of integers
      List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

      // Process the list using a parallel stream
      List<Integer> doubledNumbers = numbers.parallelStream()
              .map(n -> n * 2)
              .collect(Collectors.toList());

      // Print the result
      System.out.println("Doubled Numbers: " + doubledNumbers);
   }
}
```

When using parallel streams, you might find the follwoing version of reduce() especially helpful

```java
<U> U reduce(U identity,
               BiFunction<U, ? super T, U> accumulator,
               BinaryOperator<U> combiner);
```

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ReduceExample {
    public static void main(String[] args) {
        // List of strings
        List<String> strings = Arrays.asList("Java", "Stream", "Reduce");

        // Identity value
        Integer identity = 0;

        // Accumulator: Adds the length of the current string to the total
        BiFunction<Integer, String, Integer> accumulator = (total, str) -> total + str.length();

        // Combiner: Combines two partial results (useful for parallel streams)
        BinaryOperator<Integer> combiner = Integer::sum;

        // Using reduce with identity, accumulator, and combiner
        Integer totalLength = strings.stream()
                                     .reduce(identity, accumulator, combiner);

        // Print the result
        System.out.println("Total Length of Strings: " + totalLength);
    }
}
```

You can switch a parallel stream to sequential by calling the sequential() method, which is specified in BaseStream

```java
Stream<T> sequential();
```

Streams can either be ordered or unordered.
In general, if the data source is ordered, then the stream will be ordered.
However, when using aparallel stream, a performance boost can sometimes be obtained by allowing a stream to be unordered.

When a parallel stream is unordered, each partition of the stream can be operated on independently, without having to coordinate with the others.

```java
Stream<T> unordered();
```

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UnorderedParallelStreamExample {
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using parallel stream with unordered()
        List<Integer> evenNumbers = numbers.parallelStream()
                                           .unordered() // Allow unordered processing
                                           .filter(n -> n % 2 == 0) // Filter even numbers
                                           .collect(Collectors.toList());

        // Print the result
        System.out.println("Even Numbers: " + evenNumbers);
    }
}
```

### Mapping

The most general mapping method is map()

```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
```

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomFunctionMapExample {
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Custom function to square a number
        Function<Integer, Integer> squareFunction = num -> num * num;

        // Use map to apply the custom function
        List<Integer> squaredNumbers = numbers.stream()
                                              .map(squareFunction)
                                              .collect(Collectors.toList());

        // Print the result
        System.out.println("Squared Numbers: " + squaredNumbers);
    }
}
```

Function is a functional interface that represents a function that takes one argument and produces a result.

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```   

T is the element type and R is the result of the mapping.

### Collectors

The Collectors class provides various static methods that return Collector instances.
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class CollectorsExample {
    public static void main(String[] args) {
        // List of strings
        List<String> strings = Arrays.asList("Java", "Stream", "Collectors");

        // Use Collectors.joining() to concatenate strings with a delimiter
        String result = strings.stream()
                               .collect(Collectors.joining(", "));

        // Print the result
        System.out.println("Concatenated String: " + result);
    }
}
```

The collect method has two forms

```java
<R, A> R collect(Collector<? super T, A, R> collector);
```

R - the type of the result
A - the intermediate accumulation type
T - the element type of the stream

```java
<R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);
```

R - the type of the result
T - the element type of the stream

The accumulator function adds an element to the result and combiner combines two partial results.

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CustomCollectExample {
    public static void main(String[] args) {
        // Stream of integers
        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5);

        // Custom collect implementation
        Supplier<StringBuilder> supplier = StringBuilder::new; // Creates a new StringBuilder
        BiConsumer<StringBuilder, Integer> accumulator = (sb, num) -> sb.append(num).append(" "); // Appends each number
        BiConsumer<StringBuilder, StringBuilder> combiner = StringBuilder::append; // Combines two StringBuilders

        // Collect the stream into a StringBuilder
        StringBuilder result = numberStream.collect(supplier, accumulator, combiner);

        // Print the result
        System.out.println("Collected Result: " + result.toString().trim());
    }
}
```

Collectors class defines a number of static collector methods.
```java
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;
public class CollectorsGroupingByExample {
    public static void main(String[] args) {
        // List of strings
        List<String> fruits = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");

        // Grouping fruits by their first letter
        Map<Character, List<String>> groupedFruits = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit.charAt(0)));

        // Print the grouped fruits
        for (Map.Entry<Character, List<String>> entry : groupedFruits.entrySet()) {
            System.out.println("Fruits starting with '" + entry.getKey() + "': " + entry.getValue());
        }
    }
}
```

### Use an Iterator with Stream

An Iterator is an object that enables you to traverse a collection, obtaining each element in turn.
The Iterator interface defines three methods:

```java
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorWithStreamExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Create a stream from the list
        Stream<Integer> numberStream = numbers.stream();

        // Obtain an iterator from the stream
        Iterator<Integer> iterator = numberStream.iterator();

        // Use the iterator to traverse the stream
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

### Using an Spliterator with stream

```java
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorWithStreamExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Create a stream from the list
        Stream<Integer> numberStream = numbers.stream();

        // Obtain a Spliterator from the stream
        Spliterator<Integer> spliterator = numberStream.spliterator();

        // Use tryAdvance to process one element at a time
        System.out.println("Processing one element at a time:");
        spliterator.tryAdvance(System.out::println);

        // Use forEachRemaining to process the remaining elements
        System.out.println("Processing remaining elements:");
        spliterator.forEachRemaining(System.out::println);
    }
}
```

The Spliterator interface provides methods for traversing and partitioning elements of a source.
The Spliterator interface defines two primary methods for traversing elements: tryAdvance() and forEachRemaining().

```java
boolean tryAdvance(Consumer<? super T> action);
void forEachRemaining(Consumer<? super T> action);
```

The tryAdvance() method processes a single element if one is available, returning true if an element was processed and false if no more elements are available.
The forEachRemaining() method processes all remaining elements in the spliterator.

To determine if one or more elements in a stream satisfy a specified predicate, use anyMatch(), allMatch(), or noneMatch().

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
public class StreamMatchExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Create a stream from the list
        Stream<Integer> numberStream = numbers.stream();

        // Define a predicate to check if a number is even
        Predicate<Integer> isEven = num -> num % 2 == 0;

        // Check if any number is even
        boolean anyEven = numberStream.anyMatch(isEven);
        System.out.println("Any even number: " + anyEven);

        // Reset the stream for further operations
        numberStream = numbers.stream();

        // Check if all numbers are even
        boolean allEven = numberStream.allMatch(isEven);
        System.out.println("All numbers are even: " + allEven);

        // Reset the stream for further operations
        numberStream = numbers.stream();

        // Check if no numbers are even
        boolean noneEven = numberStream.noneMatch(isEven);
        System.out.println("No even numbers: " + noneEven);
    }
}
```

## Regular Expressions

A regular expression is a sequence of characters that forms a search pattern.
You can use a regular expression to check if a string contains the specified search pattern.

### The Pattern Class

The Pattern class is a compiled representation of a regular expression.
You can create a Pattern object by calling the static compile() method of the Pattern class.

```java
import java.util.regex.Pattern;
public class PatternExample {
    public static void main(String[] args) {
        // Create a Pattern object for a simple email regex
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

        // Print the pattern
        System.out.println("Email Pattern: " + emailPattern.pattern());
    }
}
```

### The Matcher Class

The Matcher class is used to perform match operations on a character sequence using a Pattern.
You can create a Matcher object by calling the matcher() method of the Pattern class.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExample {
   public static void main(String[] args) {
      // Define a regex pattern to match words starting with 'J'
      String regex = "\\bJ\\w+";
      String input = "Java is a popular programming language. JavaScript is also widely used.";

      // Compile the regex pattern
      Pattern pattern = Pattern.compile(regex);

      // Create a matcher for the input string
      Matcher matcher = pattern.matcher(input);

      // Find and display matches
      System.out.println("Words starting with 'J':");
      while (matcher.find()) {
         System.out.println(matcher.group());
      }
   }
}
```

The Pattern and Matcher classes do not have any constructor.

Instead a Pattern is created by calling the compile() factory method.
A Matcher is created by calling the matcher() method of a Pattern object.

The simplest pattern matching method is matches(), which simply determines whether the character sequence matches the pattern.

```java
boolean matches(CharSequence input);
```

To determine if a sequence of the input sequence matches the pattern use find().
It returns true if such a match is found.

### Regular Expression Syntax

The following table summarizes some of the most commonly used regular expression constructs:

| Construct      | Description                                      | Example            |
|----------------|--------------------------------------------------|--------------------|
| `.`            | Matches any single character                      | `a.b` matches `acb`|
| `*`            | Matches zero or more occurrences of the preceding element | `ab*` matches `a`, `ab`, `abb` |
| `+`            | Matches one or more occurrences of the preceding element | `ab+` matches `ab`, `abb`, but not `a` |
| `?`            | Matches zero or one occurrence of the preceding element | `ab?` matches `a`, `ab` |
| `\d`           | Matches any digit (equivalent to `[0-9]`)        | `\d+` matches `123`|
| `\w`           | Matches any word character (alphanumeric + underscore) | `\w+` matches `hello_123` |
| `\s`           | Matches any whitespace character                  | `\s+` matches spaces, tabs |
| `^`            | Matches the beginning of a line                   | `^abc` matches `abc` at the start of a line |
| `$`            | Matches the end of a line                         | `abc$` matches `abc` at the end of a line |
| `[]`           | Matches any one of the characters inside the brackets | `[abc]` matches `a`, `b`, or `c` |
| `|`            | Logical OR operator                              | `abc|def` matches `abc` or `def` |
| `()`           | Groups multiple tokens together                   | `(abc)+` matches `abc`, `abcabc` |
### Example of Regular Expression

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexPatternMatchingExample {
   public static void main(String[] args) {
      // Example 1: Match a word starting with 'J' and followed by any characters
      String regex1 = "\\bJ\\w+";
      String input1 = "Java and JavaScript are popular languages.";
      System.out.println("Words starting with 'J':");
      matchAndPrint(regex1, input1);

      // Example 2: Match a valid email address
      String regex2 = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
      String input2 = "Contact us at support@example.com or sales@company.org.";
      System.out.println("\nValid email addresses:");
      matchAndPrint(regex2, input2);

      // Example 3: Match a phone number in the format (XXX) XXX-XXXX
      String regex3 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
      String input3 = "Call us at (123) 456-7890 or (987) 654-3210.";
      System.out.println("\nPhone numbers:");
      matchAndPrint(regex3, input3);

      // Example 4: Match a date in the format YYYY-MM-DD
      String regex4 = "\\d{4}-\\d{2}-\\d{2}";
      String input4 = "Important dates: 2023-10-01, 2024-01-15.";
      System.out.println("\nDates in YYYY-MM-DD format:");
      matchAndPrint(regex4, input4);

      // Example 5: Match a sequence of digits (numbers)
      String regex5 = "\\d+";
      String input5 = "The order numbers are 12345, 67890, and 54321.";
      System.out.println("\nNumbers:");
      matchAndPrint(regex5, input5);

      // Example 6: Match words with only uppercase letters
      String regex6 = "\\b[A-Z]+\\b";
      String input6 = "The acronyms are NASA, FBI, and CIA.";
      System.out.println("\nUppercase words:");
      matchAndPrint(regex6, input6);
   }

   // Utility method to match and print results
   private static void matchAndPrint(String regex, String input) {
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);
      while (matcher.find()) {
         System.out.println(matcher.group());
      }
   }
}
```

### Example Output

```
Words starting with 'J':
Java
JavaScript

Valid email addresses:
support@example.com
sales@company.org

Phone numbers:
(123) 456-7890
(987) 654-3210

Dates in YYYY-MM-DD format:
2023-10-01
2024-01-15

Numbers:
12345
67890
54321

Uppercase words:
NASA
FBI
CIA
```

### Using Wildcards and Quantifiers

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class WildcardsQuantifiersExample {
   public static void main(String[] args) {
      // Example: Match words with wildcards and quantifiers
      String regex = "a.*b"; // Matches 'a' followed by any characters and ending with 'b'
      String input = "ab acb a123b aXYZb a b";

      System.out.println("Words matching the pattern 'a.*b':");
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);
      while (matcher.find()) {
         System.out.println(matcher.group());
      }
   }
}
```

### Example Output

```
Words matching the pattern 'a.*b':
ab
acb
a123b
aXYZb
a b
```

### Working with Classes of Characters

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class CharacterClassesExample {
   public static void main(String[] args) {
      // Example: Match words with specific character classes
      String regex = "\\b[aeiouAEIOU]\\w*"; // Words starting with a vowel
      String input = "Apple banana Orange umbrella cat Elephant";

      System.out.println("Words starting with a vowel:");
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);
      while (matcher.find()) {
         System.out.println(matcher.group());
      }
   }
}
```

### Example Output

```
Words starting with a vowel:
Apple
Orange
umbrella
Elephant
```

### Using replaceAll()

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ReplaceAllExample {
   public static void main(String[] args) {
      // Example: Replace all occurrences of a pattern
      String regex = "\\d+"; // Matches one or more digits
      String input = "My phone number is 123-456-7890 and my zip code is 98765.";

      // Replace all digits with 'X'
      String result = input.replaceAll(regex, "X");

      System.out.println("Original String: " + input);
      System.out.println("Modified String: " + result);
   }
}
```

### Using split()

```java
import java.util.regex.Pattern;
public class SplitExample {
   public static void main(String[] args) {
      // Example: Split a string using a regex pattern
      String regex = "\\s*,\\s*"; // Split by commas with optional spaces
      String input = "apple, banana, cherry, date";

      // Split the string
      String[] fruits = input.split(regex);

      System.out.println("Fruits:");
      for (String fruit : fruits) {
         System.out.println(fruit);
      }
   }
}
```

### Two Pattern-Matching Options

The Pattern class provides two methods for pattern matching: matches() and lookingAt().
The matches() method attempts to match the entire input sequence against the pattern.
The lookingAt() method attempts to match the input sequence, starting at the beginning, against the pattern.
```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class PatternMatchingOptionsExample {
   public static void main(String[] args) {
      String regex = "\\d+"; // Matches one or more digits
      String input = "123abc456";

      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);

      // Using matches()
      boolean matchesResult = matcher.matches();
      System.out.println("Using matches(): " + matchesResult); // false

      // Reset the matcher for the next operation
      matcher.reset();

      // Using lookingAt()
      boolean lookingAtResult = matcher.lookingAt();
      System.out.println("Using lookingAt(): " + lookingAtResult); // true
   }
}
```

## Reflection

Reflection is a powerful feature in Java that allows you to inspect and manipulate classes, methods, fields, and constructors at runtime.

Reflection is the ability of software to analyze itself.
It is porvided by the java.lang.reflect package and elements in Class class.

### Key Components of Reflection

1. **Class**: The Class class represents a class or interface in Java. It provides methods to obtain information about the class, such as its name, superclass, interfaces, methods, fields, and constructors.
2. **Method**: The Method class represents a method in a class or interface. It provides methods to obtain information about the method, such as its name, return type, parameter types, and modifiers.
3. **Field**: The Field class represents a field in a class or interface. It provides methods to obtain information about the field, such as its name, type, and modifiers.
4. **Constructor**: The Constructor class represents a constructor in a class. It provides methods to obtain information about the constructor, such as its name, parameter types, and modifiers.
5. **Modifier**: The Modifier class provides static methods to decode class and member access modifiers.
6. **Array**: The Array class provides static methods to create and manipulate arrays.
7. **Proxy**: The Proxy class provides static methods for creating dynamic proxy classes and instances.
8. **InvocationHandler**: The InvocationHandler interface is used in conjunction with the Proxy class to handle method invocations on proxy instances.
9. **AccessibleObject**: The AccessibleObject class is the superclass of Field, Method, and Constructor. It provides methods to set and check the accessibility of these members.
10. **Type**: The Type interface represents a generic type in Java. It is implemented by several classes, including Class, ParameterizedType, TypeVariable, and WildcardType.

### Sample Reflection Example

```java
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "Default Name";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Obtain the Class object
            Class<?> personClass = Class.forName("Person");

            // Get and print constructors
            Constructor<?>[] constructors = personClass.getDeclaredConstructors();
            System.out.println("Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Get and print fields
            Field[] fields = personClass.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println(field);
            }

            // Get and print methods
            Method[] methods = personClass.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println(method);
            }

            // Create an instance using a constructor
            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            Object personInstance = constructor.newInstance("John Doe", 30);

            // Access and modify a private field
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true); // Allow access to private field
            nameField.set(personInstance, "Jane Doe");

            // Invoke a method
            Method greetMethod = personClass.getDeclaredMethod("greet");
            greetMethod.invoke(personInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

Reflection allows you to analyze a software component and describe its capabilities dynamically, at run time rather than compile time.

`Member` defines methods that allow you to get information about a field, constructor, or method of a class.

