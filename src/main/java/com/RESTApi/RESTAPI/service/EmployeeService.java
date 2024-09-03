package com.RESTApi.RESTAPI.service;

import com.RESTApi.RESTAPI.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmplyee(int id);

}
