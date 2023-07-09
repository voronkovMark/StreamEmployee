package com.pro.sky.streamemployee.Service;

import com.pro.sky.streamemployee.Employee.Employee;
import com.pro.sky.streamemployee.Employee.EmployeeBook;
import com.pro.sky.streamemployee.Exseption.AllreadyAddedException;
import com.pro.sky.streamemployee.Exseption.EmployeeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

    List<Employee> employeeTestList = new ArrayList<>(5);
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeTestList);
    @Mock
    private EmployeeBook employeeBook;

    @Test
    void whenEmployeeNotUnique() {
        Employee employeeTest = new Employee("Test", "testLastName", 1, 100000);
        employeeTestList.add(employeeTest);
        Assertions.assertThrows(AllreadyAddedException.class, () -> {
            employeeService.add("Test", "testLastName", 1, 100000);
        });

    }

    @Test
    void addOk() {
        Employee employeeTest = new Employee("Test", "testLastName", 1, 100000);
        Assertions.assertEquals(employeeTest, employeeService.add("Test", "testLastName", 1, 100000));
    }

    @Test
    void removeWhenEmployeeWasNotFound() {
        Employee employeeTest = new Employee("Test", "testLastName", 1, 100000);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.remove("Test", "testLastName", 1, 100000);
        });
    }

    @Test
    void removeOk() {
        Employee employeeTest = new Employee("Test", "testLastName", 1, 100000);
        employeeService.add("Test", "testLastName", 1, 100000);
        Assertions.assertEquals(employeeTest, employeeService.remove("Test", "testLastName", 1, 100000));
    }

    @Test
    void findOkTest() {
        Employee employeeTest = new Employee("Test", "TestLastName", 1, 100000);
        employeeTestList.add(employeeTest);
        Assertions.assertEquals(employeeTest, employeeService.find("Test", "TestLastName", 1, 100000));
    }

    @Test
    void findEmployeeWhenHisIsNotInList() {
        Employee employeeTest = new Employee("Test", "TestLastName", 1, 100000);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.find("Test", "TestLastName", 1, 100000);
        });
    }

}
