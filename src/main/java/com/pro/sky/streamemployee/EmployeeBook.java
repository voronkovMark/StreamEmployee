package com.pro.sky.streamemployee;

import java.util.*;


public class EmployeeBook extends Employee {
    public EmployeeBook(String firstName, String lastName, int department,
                        double salary) {
        super(firstName, lastName, department, salary);
    }

    public static List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee("Andy", "Warhol", 1, 10000),

            new Employee("Jean-Michel", "Basquiat", 1, 1100000),

            new Employee("Kurt", "Cobain", 2, 2000000),

            new Employee("Jared", "Leto", 2, 2100000),

            new Employee("Johnny", "Depp", 3, 300000),

            new Employee("Angelina", "Jolie", 3, 3100000),

            new Employee("Mike", "Tyson", 4, 4000000),

            new Employee("Muhammed", "Ali", 4, 4100000),

            new Employee("Lionel", "Messi", 5, 500000),

            new Employee("Kylian", "Mbappe", 5, 5200000)

    ));





}
