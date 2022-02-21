package com.lucio.springboot.demo.controller;

import com.lucio.springboot.demo.dao.EmployeeDAO;
import com.lucio.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/employees")
public class EmployeeController {

    // constructor injection of DAO
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // get employees
    @GetMapping("")
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }
}
