package com.springbootproject.TaskAndProjectManagementApplication.controllers;
import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.EmployeeService;
import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(@Lazy EmployeeService employeeService) {
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
    @GetMapping("/")//needs fixes--produces errors because there is already a get method without a specific path (getAllemployees)
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
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable String id)
    {
        employeeService.deleteEmployeeById(id);
    }
    @PutMapping("/{id}/attach/tasks/{task-id}")//the attach word added to differentiate between attachTaskToEmployee path &  discardTaskFromEmployee path --need to be discussed
    @ResponseStatus(code = HttpStatus.OK)
    public Employee attachTaskToEmployee(@PathVariable String id, @PathVariable(name = "task-id") String taskId){
        return employeeService.attachTaskToEmployee(id,taskId);

    }
    @PutMapping("/{id}/discard/tasks/{task-id}")//the discard word added to differentiate between attachTaskToEmployee path &  discardTaskFromEmployee path --need to be discussed
    @ResponseStatus(code = HttpStatus.OK)
    public Employee discardTaskFromEmployee(@PathVariable String id,@PathVariable("task-id") String task_id){
        return employeeService.discardTaskFromEmployee(id,task_id);
    }
}
