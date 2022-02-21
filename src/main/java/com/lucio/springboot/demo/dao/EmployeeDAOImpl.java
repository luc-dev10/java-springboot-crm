package com.lucio.springboot.demo.dao;

import com.lucio.springboot.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // Dependency Injection
    private final EntityManager entityManager;

    // set up constructor injection - Autowired not necessary
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        // Session
        Session currentSession = entityManager.unwrap(Session.class);
        // query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        // execute query for list
        return query.getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
    }

    @Override
    public void deleteEmployee(int id) {
    }

    @Override
    public Employee modifyEmployee(Employee employee) {
        return null;
    }
}
