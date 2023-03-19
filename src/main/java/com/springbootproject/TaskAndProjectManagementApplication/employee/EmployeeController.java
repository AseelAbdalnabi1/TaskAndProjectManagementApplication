package com.springbootproject.TaskAndProjectManagementApplication.employee;
import com.springbootproject.TaskAndProjectManagementApplication.project.Project;
import com.springbootproject.TaskAndProjectManagementApplication.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/projects/{projectId}/employees")
    public List<Employee> getAllEmployee(@PathVariable String projectId){
        return employeeService.getAllEmployee(projectId);
    }
    @RequestMapping("/projects/{projectId}/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable String id){
        return employeeService.getEmployee(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/projects/{projectId}/employees")
    public void addEmployee(@RequestBody Employee employee,@PathVariable String projectId){
       employee.setProject(new Project(projectId,"",""));
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
        employee.setProject(new Project(projectId,"",""));
        employeeService.updateEmployee(id,employee);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/projects/{projectId}/employees/{id}")
    public void deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
    }

}
