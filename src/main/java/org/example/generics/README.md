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

