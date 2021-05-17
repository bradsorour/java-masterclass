package com.challenges.lambdas;

import java.util.function.Function;

public class Challenge3 {

    public static void main(String[] args) {

        // As lambda
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        String result = everySecondNumber(lambdaFunction, "1234567890");
        System.out.println(result);
    }

    public static String everySecondNumber(Function<String, String> lambdaFunction, String source) {
        return lambdaFunction.apply(source);
    }
}
