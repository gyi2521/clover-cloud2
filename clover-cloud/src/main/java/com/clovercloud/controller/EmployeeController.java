package com.clovercloud.controller;

import com.clovercloud.model.Employee;
import com.clovercloud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee)  {
        return employeeRepo.save(employee);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping(value="/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getOneEmployee(@PathVariable Integer employeeId) {
        return employeeRepo.getById(employeeId);
    }



}
