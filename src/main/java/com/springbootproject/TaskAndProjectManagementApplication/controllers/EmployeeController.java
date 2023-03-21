package com.springbootproject.TaskAndProjectManagementApplication.controllers;
import com.springbootproject.TaskAndProjectManagementApplication.services.EmployeeService;
import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public List<Employee> findAllEmployeeS(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/id/{id}")
    public Employee findEmployeeById(@PathVariable UUID id){
        return employeeService.findEmployeeById(id);
    }
    @GetMapping("/name/{name}")
    public List<Employee> findEmployeeByName(@PathVariable String name){
        return employeeService.findEmployeeByName(name);
    }
    @PostMapping
    public Employee addEmployee(@RequestParam("name") String name,@RequestParam("jobPosition") String jobPosition){
        return  employeeService.addEmployee(new Employee(name,jobPosition));
    }
    @PutMapping("/id/{id}")
    public Employee updateEmployeeById(@RequestBody Employee employee,@PathVariable UUID id){
        return employeeService.updateEmployeeById(id,employee);
    }
    @DeleteMapping("/id/{id}")
    public void deleteEmployeeById(@PathVariable UUID id)
    {
        employeeService.deleteEmployeeById(id);

    }

}
