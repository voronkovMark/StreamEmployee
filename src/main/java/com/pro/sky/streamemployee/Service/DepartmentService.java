package com.pro.sky.streamemployee.Service;

import com.pro.sky.streamemployee.Employee.Employee;
import com.pro.sky.streamemployee.Exseption.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }


    public Double getEmployeeMaxSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getSalary)
                .orElseThrow(EmployeeNotFoundException::new);


    }

    public Double getEmployeeMinSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getSalary)
                .orElseThrow(EmployeeNotFoundException::new);


    }

    public Double getEmployeeSalarySum(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public List<Employee> getAll(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

    }

    public List<Employee> getAll() {
        return employeeService.getAll().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());


    }

}