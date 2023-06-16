package com.pro.sky.streamemployee.Service;

import com.pro.sky.streamemployee.Employee.Employee;
import com.pro.sky.streamemployee.Exseption.EmployeeNotFoundExseption;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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