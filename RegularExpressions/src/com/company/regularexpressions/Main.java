package com.company.regularexpressions;

public class Main {

    public static void main(String[] args) {
        String str = "I am a string. Yes I am";
        System.out.println(str);

        String yourStr = str.replaceAll("I", "You");
        System.out.println(yourStr);

        String alphaNumeric = "asdaHGJK7891KLeJnAsdnasiisi335";
        System.out.println(alphaNumeric.replaceAll(".", "Y"));
        System.out.println(alphaNumeric);

        // Replace the first occurance at the start of a string with the caret ^
        System.out.println(alphaNumeric.replaceAll("^asd", "YYY"));

        System.out.println(alphaNumeric.matches("asdaHGJK7891KLJnasdnas335"));

        // Boundary matcher $ to replace the end chararcters
        System.out.println(alphaNumeric.replaceAll("335$", "THE END"));

        // Replace a, e or i with the letter x
        System.out.println(alphaNumeric.replaceAll("[aei]", "x"));

        // Replace a, e or i with the letter x, only if they are followed by a s or J
        System.out.println(alphaNumeric.replaceAll("[aei][sJ]", "X"));

        // Find word in string without upper or lower case
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        // Replace every letter in string except letters a and i
        System.out.println(alphaNumeric.replaceAll("[^ai]", "X"));

        // Replace letters and number in the range with x
        System.out.println(alphaNumeric.replaceAll("[a-h3-8]", "x"));

        // Replace letters (lowercase and uppercase) and number in the range with x
        System.out.println(alphaNumeric.replaceAll("[a-jA-J3-8]", "x"));

        // For case insensitivity use the (?i) - same result as above
        System.out.println(alphaNumeric.replaceAll("(?i)[a-j3-8]", "X"));

        // Replace all the numbers in the string
        System.out.println(alphaNumeric.replaceAll("[0-9]", "X"));

        // Replace all the numbers in the string - same result as above
        System.out.println(alphaNumeric.replaceAll("\\d", "X"));

        // Replace all the non-digits in the string
        System.out.println(alphaNumeric.replaceAll("\\D", "X"));



    }
}
