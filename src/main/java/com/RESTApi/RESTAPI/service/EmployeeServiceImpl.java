package com.RESTApi.RESTAPI.service;

import com.RESTApi.RESTAPI.Repository.EmployeeRepo;
import com.RESTApi.RESTAPI.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

private EmployeeRepo employeerepo;
@Autowired
public EmployeeServiceImpl(EmployeeRepo employeerepo) {
        this.employeerepo = employeerepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeerepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> theemployee = employeerepo.findById(id);
        Employee emp=null;
        if(theemployee.isPresent()){
           emp= theemployee.get();
        }
        return emp;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeerepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeerepo.save(employee);
    }

    @Override
    public void deleteEmplyee(int id) {
        employeerepo.deleteById(id);
    }
}
