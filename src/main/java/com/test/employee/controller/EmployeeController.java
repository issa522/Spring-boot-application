package com.test.employee.controller;

import com.test.employee.entity.Employee;
import com.test.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){

        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){

        return employeeService.getemployeeById(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){

        return employeeService.getAllemployees();
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }
}
