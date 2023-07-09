package com.pro.sky.streamemployee.Service;

import com.pro.sky.streamemployee.Employee.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {


    public Employee add(String firstName, String lastName, int department, double salary)
            throws IOException;

    public Employee find(String firstName, String lastName, int department, double salary);

    public Employee remove(String firstName, String lastName, int department, double salary);

    public List<Employee> getAll();


}








