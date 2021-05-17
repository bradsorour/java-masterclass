package com.challenges.lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class Challenge5 {

    public static void main(String[] args) {

        List<String> topNames2015 = Arrays.asList(
            "Amelia",
            "Olivia",
            "emily",
            "Isla",
            "ava",
            "oliver",
            "Jack",
            "Charlie",
            "harry",
            "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();

        topNames2015.forEach(s -> {
            firstUpperCaseList.add(s.substring(0, 1).toUpperCase() + s.substring(1));
        });

        List<String> secondSortedList = firstUpperCaseList
            .stream()
            .sorted()
            .collect(Collectors.toList());

        System.out.println("secondSortedList: " + secondSortedList);
        secondSortedList.forEach(s -> System.out.println(s));
        System.out.println("================");

        // Using lambdas
        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("firstUpperCaseList: " + firstUpperCaseList);
        firstUpperCaseList.forEach(s -> System.out.println(s));

        // Using Method References
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        // Using stream and a chain of stream operations
        topNames2015
            .stream()
            .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
            .sorted(String::compareTo)
            .forEach(System.out::println);

        System.out.println("================");

        long startsWithA = topNames2015
            .stream()
            .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
            .filter(name -> name.startsWith("A"))
            .count();

        System.out.println("Names beginning with A: " + startsWithA);

        System.out.println("~~~~~~~~~~~~~~~");

        // Terminal operation so that peek call will execture
        topNames2015
            .stream()
            .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
            .peek(System.out::println)
            .sorted(String::compareTo)
            .findAny();
    }
}

