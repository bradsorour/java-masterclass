package com.company.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> someBingoNumbers = Arrays.asList
            (
                "N40", "N36",
                "B12", "B6",
                "C53", "G49", "g54",
                "G60", "G50",
                "I29", "I70",
                "O71", "097"
            );

        // Using Lambdas
        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });

        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
        gNumbers.forEach((String s) -> System.out.println(s));

        // Using Streams
        someBingoNumbers
            .stream()
            .map(String::toUpperCase)
            .filter(s -> s.startsWith("G"))
            .sorted()
            .forEach(System.out::println);

        //System.out.println(someBingoNumbers);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "087");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        //System.out.println(concatStream.count());
        System.out.println("-----------------------------");
        System.out.println(concatStream
            .distinct()
            .peek(System.out::println)
            .count());

        Employee john = new Employee("John Doe", 28);
        Employee jane = new Employee("Jane Deer", 31);
        Employee brad = new Employee("Brad Sorour", 42);
        Employee steve = new Employee("Steve Smith", 42);
        Employee angela = new Employee("Angela Doyle", 12);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(jane);
        hr.addEmployee(brad);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(angela);
        accounting.addEmployee(steve);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        // Flat Map (to flatten nested list)
        departments
            .stream()
            .flatMap(department -> department.getEmployees().stream())
            .forEach(System.out::println);


        // Stream with collector
        //List<String> sortedGNumbers = someBingoNumbers
        //    .stream()
        //    .map(String::toUpperCase)
        //    .filter(s -> s.startsWith("G"))
        //    .sorted()
        //    .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
            .stream()
            .map(String::toUpperCase)
            .filter(s -> s.startsWith("G"))
            .sorted()
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println("=============");
        System.out.println(sortedGNumbers);

        for (String sortedGNumber : sortedGNumbers) {
            System.out.println(sortedGNumber);
        }

        // Grouping By
        Map<Integer, List<Employee>> groupedByAge = departments
            .stream()
            .flatMap(department -> department.getEmployees().stream())
            .collect(Collectors.groupingBy(employee -> employee.getAge()));

        System.out.println("groupedByAge");
        System.out.println(groupedByAge);

        // Reducing
        System.out.println("youngest");

        departments.stream()
            .flatMap(department -> department.getEmployees().stream())
            .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
            .ifPresent(System.out::println);


        Stream.of("ABC", "AC", "BAA", "CCC", "XY", "ST")
            .filter(s -> {
                System.out.println(s);
                return s.length() == 3;
            })
        .count();

    }

}
