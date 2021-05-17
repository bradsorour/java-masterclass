package com.company.lambdas;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John", 28);
        Employee brad = new Employee("Brad", 42);
        Employee angela = new Employee("Angela", 50);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(brad);
        employees.add(angela);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        //for (Employee employee : employees) {
        //    System.out.println(employee.getName());
        //    System.out.println(employee.getAge());
        //    //new Thread(() -> System.out.println(employee.getAge())).start();
        //}

        //AnotherClass anotherClass = new AnotherClass();
        //anotherClass.printValue();
        //String s = anotherClass.doSomething();
        //System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething() {

        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression class is " + getClass().getSimpleName());
            System.out.println("i inside the lambda" + i);
            return s1.toUpperCase() + s2.toUpperCase();
        };

        System.out.println("The AnotherClass name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }

    public void printValue() {

        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}
