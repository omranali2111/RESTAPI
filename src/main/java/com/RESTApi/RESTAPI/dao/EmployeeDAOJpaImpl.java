package com.RESTApi.RESTAPI.dao;


import com.RESTApi.RESTAPI.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmplyee(int id) {
       Employee employee= entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }

}











