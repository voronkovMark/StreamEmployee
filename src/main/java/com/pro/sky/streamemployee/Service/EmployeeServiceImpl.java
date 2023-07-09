package com.pro.sky.streamemployee.Service;

import com.pro.sky.streamemployee.Employee.Employee;
import com.pro.sky.streamemployee.Employee.EmployeeBook;
import com.pro.sky.streamemployee.Exseption.AllreadyAddedException;
import com.pro.sky.streamemployee.Exseption.EmployeeNotFoundException;
import com.pro.sky.streamemployee.Exseption.RenameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    @Override
    public Employee add(String firstName, String lastName, int department, double salary) throws AllreadyAddedException {
        Employee employee = new Employee(firstName, lastName, department, salary);
        inputValidate(firstName, lastName);

        if (employeeList.contains(employee)) {
            throw new AllreadyAddedException();
        }

        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, int department, double salary) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName, department, salary);
        inputValidate(firstName, lastName);

        if (employeeList.contains(employee)) {
            return employee;
        }

        throw new EmployeeNotFoundException();

    }

    @Override
    public Employee remove(String firstName, String lastName, int department, double salary) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName, department, salary);
        inputValidate(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }

        throw new EmployeeNotFoundException();

    }


    @Override
    public List<Employee> getAll() {

        return Collections.unmodifiableList(EmployeeBook.employeeList);
    }

    public void inputValidate(String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new RenameException();
        }
    }


}
