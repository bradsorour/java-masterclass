package com.challenges.lambdas;

import java.util.function.Supplier;

public class Challenge4 {

    public static void main(String[] args) {

        //Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJava = () -> {
            return "I love Java!";
        };

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

    }
}
