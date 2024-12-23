package org.example.basics;

public class Loops {
    public static void main(String[] args) {
        int value = 3;
        switch(value) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3: case 4: case 5:
                System.out.println("Was among 3,4,5");
                //break;
            default:
                System.out.println("def");
                break;
        }
        // Valid switch value types - byte, short, int, char, Byte, Short, Integer, Character, String, enum
        // We cannot use long, float, double or boolean or their wrappers in switch statement
        // Once a switch case label matches the switch varible, no more cases are checked
        // ANy code after the case label where there was a match found, will be executed, until
        // a break statement or the end of the switch statement occurs
        // WIthout break statement execution will continue to fall through any case labels declated below the matching one
        // and execute each case's code

        switch (value) {
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            case 3, 4, 5 -> {
                System.out.println("Was 3,4,5");
            }
            default -> System.out.println("def");
        }
        // return can be used with switch statements to return a value from methods
        // switch can be encapsulated with return statement
        System.out.println(getQuarter("April1"));

        // for loop
        for (int counter = 1; counter <= 5; counter++) {
            System.out.println(counter);
        }

        int countOfMatches = 0;
        int sumOfMatches   = 0;

        for(int loopNumber = 1; loopNumber <= 1000; loopNumber++) {
            if ((loopNumber % 3 == 0) && (loopNumber % 5 == 0)) {
                countOfMatches++;
                sumOfMatches += loopNumber;
                System.out.println("FOund a match "+loopNumber);
            }

            if (countOfMatches == 5){
                break; // only find 5 numbers divisible by 3 & 5
            }
        }
        System.out.println(sumOfMatches);

        // while loop
        int i = 1;
        while (i <= 5) {
            // cannot decalre variables in while loop like we did in for
            System.out.println(i);
            i++;
        }

        // do while loop
        boolean isReady = false;
        int j = 1;
        do { // do block will always execute in loop iteration
            if (j > 5) {
                break;
            }
            System.out.println(j);
            j++;
        } while (isReady);

        int number = 0;
        while (number < 50) {
            number += 5;
            if ( number % 25 == 0) {
                continue; // control moves on to the next loop iteration and lines below are skipped for the current loop iteration
            }
            System.out.print(number + "_");
        }

        // A local variable is called local because it is only available for use in the code block
        // Scope describes the accessibility of a variable
        // IN scope means the variable can be used by an executing block or any nested block
        // Out of scope means the variable is no longer available and cannot be used
    }

    public static String getQuarter(String month) {
        return switch (month) {
            case "January", "February", "March" -> "1st";
            case "April", "May", "June" -> "2nd";
            case "July", "August", "September" -> "3rd";
            case "October", "November", "December" -> "4th";
            default -> {
                String badResponse = month + " is invalid";
                yield badResponse;
            }
        };
    }
}
