package com.pro.sky.streamemployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                String lastName,
                                int deparment,
                                double salary) {
        return service.add(firstName, lastName,deparment,salary);
    }@GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,@RequestParam String lastName,int deparment,
                                   double salary) {
        return service.remove(firstName, lastName,deparment,
        salary);
    }@GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,@RequestParam String lastName,int deparment,
                                 double salary) {
        return service.find(firstName, lastName,deparment,salary);
    }
    @GetMapping
    public List<Object> getAll(){
        return  service.getAll();
    }

}
