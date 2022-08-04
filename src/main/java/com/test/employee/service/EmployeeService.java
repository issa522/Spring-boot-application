package com.test.employee.service;

import com.test.employee.dao.EmployeeRepository;
import com.test.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
@Autowired
   private EmployeeRepository employeeRepository;

public Employee createEmployee(Employee employee){
 return employeeRepository.save(employee);
}

public Employee getemployeeById(int id) {

    return employeeRepository.findById(id).orElse(null);
}

    public List<Employee> getAllemployees() {
        return employeeRepository.findAll();
    }


    public Employee updateEmployee(Employee employee){
        Employee existingEmployee=employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        return employeeRepository.save(existingEmployee);
    }

    public String deleteEmployeeById(int id){
      employeeRepository.deleteById(id);
      return "Employee Deleted!";
    }

}
