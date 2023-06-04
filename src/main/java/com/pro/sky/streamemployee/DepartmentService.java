package com.pro.sky.streamemployee;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    public Employee employeeWithMaxSalary(int department) {
//        employeeService.getAll().stream()
//                .filter(e->e.getDepartment()==department)
//                .max(e->e.getSalary)
//        return
//    }

}