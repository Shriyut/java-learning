# Generics

Generics enable us to create and design classes in a generalized manner, without being concerned about the specific details of the elements they might contain.

Generics are a feature of the Java programming language that allows you to define classes, interfaces, and methods that operate on objects of a specified type.

ArrayList is a generic.

### Regular Class

```java
class Tell {
    private String field;
}
```

### Generic Class

```java
class generic<T> {
    private T field;
}

public class Team<T extends Player> {} // T has to be a Player or subtype of Player
```

T is the placeholder for a type that will be specified later.

This is called a type identifier, and it can be any letter or word, but T which is short for Type is most commonly used.

In the declaration of a reference type that uses generics, the type parameter is declared in angle brackets.

The reference type is ArrayList, the type parameter ( or parameterized type) is String, which is declared in angle brackets, and listOfString is the variable name.

```java
ArrayList<String> listOfString;
```

The most commonly used type parameter identifiers are:

- E for an element
- K for a key
- V for a value
- N for a number
- T for a type
- S, U, V, and so forth for multiple types

Generics allow the compiler to do compile-time type checking when adding and processing elements in the list.

Generics simplify code, because we don't have to do our own type checking and casting as we would if the type of our elements was Object.

For a method, type parameters are placed after any modifiers and before the method's return type.

The type parameter can be referenced in method parameters, as the method return type, and in the method code block, much as we have seen how a class's type parameter can be used.

A generic method can be used for collections with type arguments to allow variability of the elements in the collection, without using a raw version of the collection.

A generic method can be used for static methods on a generic class, because static methods can't use class type parameters.

A generic method can be used on a non-generic class, to enforce type rules on a specific method.

The generic method type parameter is separate from a generic class type parameter.

```java
public <T> String myMethod(T input){
    return input.toString();
}
```

## Type Parameters, Type Arguments and using a wildcard

Type parameters are used to define the type of elements in a generic class or method.

A type parameter is a generic class, or generic method's declaration of the type. You can bind a type parameter with the use of the extends keyword, to specify an upperbound.

```java
// generic class

public class Team<T> {};

//generic method

public <T> void doSomething(T t) {};
```

A type argument declares the type to be used, and is specified in a type reference, such as a local variable reference, method parameter declaration, or field declaration.

```java
// generic class
Team<BaseballPlayer> team = new Team<>();
```

A wildcard can only be used in a type argument, not in the type parameter declaration.

A wildcard is represented by the ? character.

A wildcard means that the type is unknown.

```java
List<?> unknownList;
```

A wild card can't be used in an instantiation of a generic class.

```java
// code shown below is invalid
var myList = new ArrayList<?>();
```

![wildcard](img.png)

```java
public static void testList(List<?> list) {
    for (Object o : list) {
        System.out.println(o);
    }
}
```

Class's type parameter cannot be used with a static method, the generic class's type parameter only has meaning for the instance and therefore instance methods at the class level the generic is unknown.

When generic classes are loaded into memory, the type parameter is erased, and the class is loaded as a raw type. A generic method's type is unrelated to the type declared on the generic class.

```java
public static <T> List<T> getMatches (List<T> items){};
//the T after static and the T in List<T> are treated differently

```

