package org.example.basics;

public class Variables {
    public static void main(String[] args) {
        // Sample class to depict how variables are used in java
        int sampleNumber = 5; // declaration statement value is optional
        System.out.println(sampleNumber+1);
        // expression is a coding construct that evaluates to a single value
        // expression is defined on the RHS of = symbol in declaration statement

        // Wrapper classes are data types that provide additional functionality that primitive types dont

        // primitive types in java (Equivalent Wrapper Class)
        // whole numbers    - byte, short int, long  (Byte, Short, Integer, Long)
        // single character - char                   (Character)
        // real numbers     - float, double          (Float, Double)
        // boolean          - boolean                (Boolean)
        // primitive data types are simply placeholders in memory of a value

        int minIntValue = Integer.MIN_VALUE;
        System.out.println("Minimum supported int value in java is "+minIntValue);

        // Java uses the concept of wrapper class, for all of its eight primitive data types

        // A wrapper class provides simple operations as well as some basic information about
        // the primitive data type which cannot be stored in the primitive data type itself

        // if a larger than maximum value is being assigned to an int it will result in an overflow situation
        // if we add 1 to max int value java compiler providers the minimum supported integer value
        // if we subtract 1 from minimum supported value the java compiler provider the maximum supported integer value
        // the above situation is called an underflow situation
        // THe maximum value when it overflows, wraps around to the mininum value and continues processing without an error
        // THe minimum value when it underflows wraps around to the maximum value and continues processing
        // NOTE - Assigning a value outside the supported range will result in an error

        // java provides a way to improve readability using _
        int testNum = 2_147_483_647;
        System.out.println(testNum);

        // Long has the largest range and Byte has the lowest range hencr byte takes up lowest memory ( 8 bits), long takes 64 bits, int takes 32 bits

        // Java allows certain numeric literals to have suffix appended to the value to force it to be a different data type
        // LOng is one of these types and its suffix is an L/l
        // long test = 100; int value 100 is being casted to long in this statement
        // long test = 2_147_483_647_234; will result in an error since default type for numeric values is int and the assigned value is larger than the range supported by int
        // long test = 2_147_483_647_234L;
        System.out.println("A long has a width of "+ Long.SIZE); // number can be 2 to the power of 63

        byte myMinBYteValue = Byte.MIN_VALUE, myMaxByteValue = Byte.MAX_VALUE;
        // you cannot decalre variables of different data types in a single statement (with , with ; it will work)


        //casting refers to the process of converting one data type to another
        byte myNewBYteValue = (byte) (myMinBYteValue / 2);
        // byte val = myMInBYteValue / 2; will result in an error (lossy conversion) since java doesnt know the variables value

        // Precision refers to the format and amount of space occupied by the relevant type
        // power of 10 is referred as E
        // double when compared to float can represent both a much smaller decimal value and a much
        // larger decimal value, default data type for real numbers is double (64 bits, float uses 32 bits)
        // double data type can be denoted by suffix of literal D/d and for float its F/f

        int intValue = 5; float floatValue = 5f; double doubleValue = 5d;


        // Unicode is an international encoding standard for use with differnet languages and scripts by which each letter/digit/symbol is
        // assigned a unique numeric value
        String val = "llllllll";  // not a primitive type but an in built class can store 2.14 billion characters
        System.out.println(val);

        char myUnicode = '\u0044'; // unicode value
        System.out.println(myUnicode); // D
        char myDecimalCode = 68;
        System.out.println(myDecimalCode); // D

        char firstChar = 'A', secondChar = 'B';
        System.out.println(firstChar + secondChar); // 131 doesnt concatenate but adds the numeric values denoting the char symbols
        System.out.println(""+firstChar+secondChar); // AB since the values get concatenated to empty string so java casts them

        // modulus operator % returns the remainder - / division operator
        System.out.println(10%2);
        System.out.println(10%3);

        // ternary operator
        // operand1 ? operand2 : operand3 - if operand1 is true then operand2 is executed
        // java evaluates statements with operators based on operator precedence table

    }
}
