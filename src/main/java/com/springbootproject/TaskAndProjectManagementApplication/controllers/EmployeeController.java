package com.springbootproject.TaskAndProjectManagementApplication.controllers;
import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.EmployeeService;
import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> findAllEmployeeS(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Employee findEmployeeById(@PathVariable String id){
        return employeeService.findEmployeeById(id);
    }
    @GetMapping("/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> findEmployeeByName(@PathVariable String name){
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
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable String id)
    {
        employeeService.deleteEmployeeById(id);

    }
    @PostMapping("/{id}/projects")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee addProjectToEmployee(@PathVariable String id,@RequestBody Project project){
        return employeeService.addProjectToEmployee(id,project);

    }
    @DeleteMapping("/{id}/projects")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Employee removeProjectFromEmployee(@PathVariable String id){
        return employeeService.removeProjectFromEmployee(id);
    }
    @PostMapping("/{id}/tasks")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee addTaskToEmployee(@PathVariable String id, @RequestBody Task task){
        return employeeService.addTaskToEmployee(id,task);

    }
    @DeleteMapping("/{id}/tasks/{task-id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Employee removeTaskFromEmployee(@PathVariable String id,@PathVariable("task-id") String task_id){
        return employeeService.removeTaskFromEmployee(id,task_id);
    }
}
