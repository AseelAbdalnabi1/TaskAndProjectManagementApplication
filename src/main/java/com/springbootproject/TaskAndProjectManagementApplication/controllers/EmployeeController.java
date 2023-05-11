package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Employee findEmployeeById(@PathVariable String id){
        return employeeService.findEmployeeById(id);
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> findEmployeeByName(@RequestParam(name = "name") String name){
        return employeeService.findEmployeeByName(name);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return  employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Employee updateEmployeeById(@RequestBody Employee employee,@PathVariable String id){
        return employeeService.updateEmployeeById(id,employee);
    }
}
