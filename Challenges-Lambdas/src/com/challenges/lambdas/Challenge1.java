package com.challenges.lambdas;

public class Challenge1 {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String parts[] = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        // As lambda
        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String parts[] = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        runnable1.run();
    }
}
