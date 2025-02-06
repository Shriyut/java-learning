package org.example.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 3};
        System.out.println(Arrays.toString(arr));

        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray)); //populates default value
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(fourthArray));

        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(smallerArray)); // only 5 elements
        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray)); // populates default value for extra elements

        String[] sArray = {"Able", "Mark", "Jane", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        //Binary search only works on sorted arrays
        if (Arrays.binarySearch(sArray, "Mark") >= 0){
            System.out.println("Found mark in the list");
        }

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {5,2,3,4,1};

        if (Arrays.equals(s1, s2)) {
            System.out.println("Arrays are equal");
        }else {
            System.out.println("Arrays are not equal");
        }

        int[] rndArr = getRandomArray(5);
        System.out.println(Arrays.toString(sortIntegers(rndArr)));
    }

    public static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] newInt = new int[len];
        for(int i=0; i < len; i++) {
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }

    private static int[] sortIntegers(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while(flag) {
            flag = false;
            for(int i=0; i < sortedArray.length - 1; i++) {
                temp = sortedArray[i];
                sortedArray[i] = sortedArray[i + 1];
                sortedArray[i + 1] = temp;
                flag = true;
            }
        }
        return sortedArray;
    }
}
