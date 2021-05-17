package com.company.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 28);
        Employee brad = new Employee("Brad Sorour", 42);
        Employee angela = new Employee("Angela Doyle", 50);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(brad);
        employees.add(angela);

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees under 45", employee -> employee.getAge() <= 45);
        printEmployeesByAge(employees, "\nEmployees younger than 40", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 40;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;

        System.out.println(greaterThan15.test(10));

        int a = 20;
        System.out.println(greaterThan15.test(a - 5));
        System.out.println(greaterThan15.and(lessThan100).test(10));

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(" ") + 1);
            System.out.println("lasteName: " + lastName);
        });

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        String firstName = getFirstName.apply(employees.get(0));
        String lastName = getLastName.apply(employees.get(1));
        System.out.println("=> lastname: " + firstName + " " + lastName);

        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println("First name: " + getAName(getFirstName, employee));
            } else
                System.out.println("Last name: " + getAName(getLastName, employee));
        }

        /*
        When we want to use a lambda expression in place of a method
        that accepts an argument and returns a value, we can use a function.
        */

        // Function
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName2 = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName2);
        System.out.println(chainedFunction.apply(employees.get(0)));

        // BiFunction
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    /*
    When we want to use a lambda expression that tests a
    value that returns true / false, we can use a predicate.
    */

    private static void printEmployeesByAge(
        List<Employee> employees,
        String ageTest,
        Predicate<Employee> ageCondition
    ) {

        System.out.println(ageTest);
        System.out.println("-----------------");

        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}

