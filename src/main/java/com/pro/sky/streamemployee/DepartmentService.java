package com.pro.sky.streamemployee;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.pro.sky.streamemployee.EmployeeBook.employeeList;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundExseption::new);


    }

    public Employee getEmployeeWithMinSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundExseption::new);


    }

    public List<Employee> getAll(int department) {
        return employeeService.getAll().stream()
                .filter(e->e.getDepartment()==department)
                .collect(Collectors.toList());

    }public List<Employee> getAll() {
        return employeeService.getAll().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                        .collect(Collectors.toList());



    }

}