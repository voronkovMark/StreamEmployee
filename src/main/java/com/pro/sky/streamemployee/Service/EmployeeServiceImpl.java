package com.pro.sky.streamemployee.Service;

import com.pro.sky.streamemployee.Exseption.AllreadyAddedExseption;
import com.pro.sky.streamemployee.Employee.Employee;
import com.pro.sky.streamemployee.Employee.EmployeeBook;
import com.pro.sky.streamemployee.Exseption.EmployeeNotFoundExseption;
import com.pro.sky.streamemployee.Exseption.IOExseption;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    @Override
    public Employee add(String firstName, String lastName, int department, double salary) throws IOException {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName)) {
            throw new IOExseption("Введены не все поля!");

        }else if (employeeList.contains(employee)) {
                throw new AllreadyAddedExseption();
            }

        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, int department, double salary) throws IOExseption {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName)) {
            throw new IOExseption("Введены не все поля!");
        }else if (employeeList.contains(employee)) {
                return employee;
            }

            throw new EmployeeNotFoundExseption();

    }

    @Override
    public Employee remove(String firstName, String lastName, int department, double salary) throws IOExseption{
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            throw new IOExseption("Введены не все поля!");
        }else if (employeeList.contains(employee)) {
                employeeList.remove(employee);
                return employee;
            }

            throw new EmployeeNotFoundExseption();

    }


    @Override
    public List<Employee> getAll() {

        return Collections.unmodifiableList(EmployeeBook.employeeList);
    }


}
