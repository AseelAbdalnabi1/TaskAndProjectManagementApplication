package com.springbootproject.TaskAndProjectManagementApplication.controllers;
import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.EmployeeService;
import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Employee> findAllEmployeeS(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/id/{id}")
    public Employee findEmployeeById(@PathVariable String id){
        return employeeService.findEmployeeById(id);
    }
    @GetMapping("/name/{name}")
    public List<Employee> findEmployeeByName(@PathVariable String name){
        return employeeService.findEmployeeByName(name);
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return  employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    public Employee updateEmployeeById(@RequestBody Employee employee,@PathVariable String id){
        return employeeService.updateEmployeeById(id,employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable String id)
    {
        employeeService.deleteEmployeeById(id);

    }
    @PostMapping("/{id}/projects")
    public Employee addProjectToEmployee(@PathVariable String id,@RequestBody Project project){
        return employeeService.addProjectToEmployee(id,project);

    }
    @DeleteMapping("/{id}/projects")
    public Employee removeEmployeeFromProject(@PathVariable String id){
        return employeeService.removeEmployeeFromProject(id);
    }
    @PostMapping("/{id}/tasks")
    public Employee addTaskToEmployee(@PathVariable String id, @RequestBody Task task){
        return employeeService.addTaskToEmployee(id,task);

    }
    @DeleteMapping("/{id}/tasks/{task-id}")
    public Employee removeTaskFromEmployee(@PathVariable String id,@PathVariable("task-id") String task_id){
        return employeeService.removeTaskFromEmployee(id,task_id);
    }
    /*@PostMapping("/id/{id}/projects/id/{project-id}")
    public Employee addEmployeeToProject(@PathVariable UUID id,@PathVariable("project-id") UUID project_id){
        return employeeService.addEmployeeToProject(id,project_id);

    }
    @DeleteMapping("/id/{id}/projects")
    public Employee removeEmployeeFromProject(@PathVariable UUID id){
        return employeeService.removeEmployeeFromProject(id);
    }
    @PostMapping("/id/{id}/tasks/id/{task-id}")
    public Employee addTaskToEmployee(@PathVariable UUID id,@PathVariable("task-id") UUID task_id){
        return employeeService.addTaskToEmployee(id,task_id);

    }*/


}
