package com.springbootproject.TaskAndProjectManagementApplication.controllers;
import com.springbootproject.TaskAndProjectManagementApplication.services.EmployeeService;
import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/projects/{projectId}/employees")
    public List<Employee> getAllEmployee(@PathVariable String projectId){
        return employeeService.getAllEmployee(projectId);
    }
    @RequestMapping("/projects/{projectId}/employees/{id}")
    public Employee getEmployee(@PathVariable String id){
        return employeeService.getEmployee(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/projects/{projectId}/employees")
    public void addEmployee(@RequestBody Employee employee,@PathVariable String projectId){
      //employee.setProject(new Project(projectId,"",""));
        /* List<Task> task=new ArrayList<>();
        task.add(new Task(taskId,"",""));
        employee.setTask(task);*/
        employeeService.addEmployee(employee);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/projects/{projectId}/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable String projectId,@PathVariable String id){
        /*List<Task> task=new ArrayList<>();
        task.add(new Task(taskId,"",""));
        employee.setTask(task);*/
        //employee.setProject(new Project(projectId,"",""));
        employeeService.updateEmployee(id,employee);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/projects/{projectId}/employees/{id}")
    public void deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
    }

}
