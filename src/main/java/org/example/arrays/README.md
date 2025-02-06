# Arrays

An array is a data structure that allows you to store a sequence of values, all of the same type

YOu can have arrays for any of the 8 primitive types or any class

```java
int[] integerArray = new int[5]; // 5 denotes the size of the array
String[] nameList;
String courseList[];
```

Size of an array once created is fixed

Elements can't be added or deleted once array is instantiated

An array initializer makes the job of instantiating and initializing an array easier

```java
int[] firstFivePositives = new int[]{1,2,3,4,5};
int[] firstFourPositives = {1,2,3,4};
```
Size doesn't need to be mentioned here.

When you dont use an array intializer statement, all array elements get initialized to the default value for that type.
For primitive types this is zero for any kind of numeric primitive, for booleans it's false, and for any other class type, the elements will be initialized to null

Enhanced for loops were designed to walk through elements in an array or other collection types.]
It processes one element at a time from the frist element to the last. The enhanced for loop has two components versus three defined in the parenthesis of for loop.

A reference is an address to the object in memory but not the object itself.
