package org.example.arrays;

import java.util.Arrays;

public class ArrayBasics {

    public static void main(String[] args) {
        int[] intArray = new int[10];
        intArray[5] = 50;
        System.out.println(intArray[5]);

        double[] doubleArray = new double[10];
        doubleArray[2] = 3.5;
        System.out.println(doubleArray[2]);

        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(firstTen.length);
        System.out.println(firstTen[firstTen.length - 10]);

        int[] newArray;
//        newArray = new int[] {5, 4, 3, 2, 1};
        newArray = new int[5];
        for(int i=0; i < newArray.length; i++){
            newArray[i] = newArray.length - i;
        }

        for(int i=0; i<newArray.length; i++) {
            System.out.print(newArray[i]+" ");
        }

        // enhanced for loop
        // enhanced for loop is not suitable for setting values in an array
        for (int element: newArray) {
            System.out.println(element + " ");
        }

        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        objectArray[2] = newArray;

        // Reference Types vs Value Types

        int[] myIntArray = new int[5]; //reference type
        int[] anotherArray = myIntArray; // value type

        System.out.println("myIntArray= " + Arrays.toString(myIntArray));
        System.out.println("anotherArray= "+ Arrays.toString(anotherArray));
        anotherArray[0] = 1;

        System.out.println("after change intArray= "+Arrays.toString(myIntArray));
        System.out.println("after change anotherArray= "+Arrays.toString(anotherArray)); //same output as above


    }
}
