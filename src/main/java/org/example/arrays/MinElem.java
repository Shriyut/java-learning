package org.example.arrays;

import java.util.Scanner;

public class MinElem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide comma separated numbers");
        String vals = sc.nextLine();
        // non static element can not be referenced from static context
        System.out.println(getMin(getArray(vals)));
    }

    public static int[] getArray(String values){
        String[] strArray = values.split(",");
        int[] intArray = new int[strArray.length];
        for (int i=0; i < strArray.length; i++){
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static int getMin(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        for(int element : arr) {
            if (element < minValue) {
                minValue = element;
            }
        }
        return minValue;
    }
}
