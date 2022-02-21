package com.lucio.springboot.demo.controller;

import com.lucio.springboot.demo.entity.Employee;
import com.lucio.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/employees")
public class EmployeeController {

    // constructor injection of service
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get employees
    @GetMapping("")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // get one employee
    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

}
