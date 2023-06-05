package com.pro.sky.streamemployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentID") int department) {
        return departmentService.getEmployeeWithMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentID") int department) {
        return departmentService.getEmployeeWithMinSalary(department);
    }

    @GetMapping( value = "/all",params = "departmentID")
    public List<Employee> getAll(@RequestParam("departmentID") int department) {
        return departmentService.getAll(department);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return departmentService.getAll();
    }


//    @GetMapping
//    public List<Object> all() {
//        return Collections.singletonList(departmentService.all());
//    }


}
