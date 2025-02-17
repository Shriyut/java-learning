# Enums

A special data type that contains predefined constants.

An enum is like an array, except its elements are known, not changeable, and each element can be referred to by a constant name, instead of an index position.

Enums are used when we know all possible values at compile time, such as choices on a menu, rounding modes, command line flags, etc.

An enum is described like a class. However the keyword enum replaces the keyword class.

```java
public enum DayOfTheWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
 ```

Within the enum body, you declare a list of constant identifiers, separated by commas, by convention these are all uppercase labels.

An enum is ordered, by the way you declare the constants.

