package com.pro.sky.streamemployee.Service;

import com.pro.sky.streamemployee.Employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    private static Collection<Employee> EMPLOYEES = Arrays.asList(
            new Employee("Sergey", "Andreev", 1, 100000),
            new Employee("Andrey", "Sergeev", 1, 1000),
            new Employee("Olga", "Viktorova", 2, 150000),
            new Employee("Elena", "Aleksandrova", 2, 155500),
            new Employee("Nikolay", "Subbotin", 3, 177700)
    );
    @Mock
    EmployeeServiceImpl employeeService;
    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void init() {
        when(employeeService.getAll()).thenReturn((List<Employee>) EMPLOYEES);
    }


    @Test
    void getMaxSalaryTest() {
        double actual = departmentService.getEmployeeMaxSalary(1);
        Assertions.assertEquals(100000, actual);
    }

    @Test
    void getWMinSalaryTest() {
        double actual = departmentService.getEmployeeMinSalary(2);
        Assertions.assertEquals(150000, actual);
    }

    @Test
    void getSumSalaryOfDepartment() {
        double actual = departmentService.getEmployeeSalarySum(1);
        Assertions.assertEquals(101000, actual);
    }


    @Test
    void incorrectDepartment() {
        List<Employee> all = departmentService.getAll(5);
        Assertions.assertTrue(all.isEmpty());
    }


}



