package com.pro.sky.streamemployee.Controller;

import com.pro.sky.streamemployee.Employee.Employee;
import com.pro.sky.streamemployee.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/max-salary")
    public Double getEmployeeMaxSalary(@RequestParam("departmentID") int department) {
        return departmentService.getEmployeeMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Double getEmployeeMinSalary(@RequestParam("departmentID") int department) {
        return departmentService.getEmployeeMinSalary(department);
    }

    @GetMapping("/sum")
    public Double getSalarySumByDepartment(@RequestParam("departmentID") int department) {
        return departmentService.getEmployeeSalarySum(department);
    }

    @GetMapping(value = "/all", params = "departmentID")
    public List<Employee> getAll(@RequestParam("departmentID") int department) {
        return departmentService.getAll(department);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return departmentService.getAll();
    }


}
