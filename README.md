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
