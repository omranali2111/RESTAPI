package com.RESTApi.RESTAPI.controller;


import com.RESTApi.RESTAPI.entity.Employee;
import com.RESTApi.RESTAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmloyeeController {

    private EmployeeService employeeService;

@Autowired
    public EmloyeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/find")
    public Employee findById(@RequestParam int id){
     return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
     employeeService.addEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
    employee.setId(0);
    return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam int id){
    employeeService.deleteEmplyee(id);
    }
}


