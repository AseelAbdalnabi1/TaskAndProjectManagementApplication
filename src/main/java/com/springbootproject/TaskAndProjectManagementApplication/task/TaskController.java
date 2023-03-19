package com.springbootproject.TaskAndProjectManagementApplication.task;

import com.springbootproject.TaskAndProjectManagementApplication.employee.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @RequestMapping("/projects/{projectId}/tasks")
    public List<Task> getAllTasksInProject(@PathVariable String projectId){
        return taskService.getAllTasksInProject(projectId);
    }
    @RequestMapping("/projects/{projectId}/employees/{employeeId}/tasks")
    public List<Task> getAllTasks(@PathVariable String employeeId){
        return taskService.getAllTasksToEmployee(employeeId);
    }
    @RequestMapping("/projects/{projectId}/tasks/{id}")
    public Optional<Task> getTask(@PathVariable String id){
        return taskService.getTask(id);
    }

    @RequestMapping(method = RequestMethod.POST,value="/projects/{projectId}/employees/{employeeId}/tasks")
    public void addTask(@RequestBody Task task,@PathVariable String projectId,@PathVariable String employeeId){
        task.setProject(new Project(projectId,"",""));
        task.setEmployee(new Employee(employeeId,"",""));
        taskService.addTask(task);
    }

    @RequestMapping(method = RequestMethod.PUT,value="/projects/{projectId}/employees/{employeeId}/tasks/{id}")
    public void updateTask(@RequestBody Task task,@PathVariable String projectId,@PathVariable String employeeId,@PathVariable String id){
        task.setProject(new Project(projectId,"",""));
        task.setEmployee(new Employee(employeeId,"",""));
        taskService.updateTask(task,id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/projects/{projectId}/tasks/{id}")
    public void deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
    }
    /*@RequestMapping(method = RequestMethod.DELETE,value="/projects/{projectId}/employees/{employeeId}/tasks/{id}")
    public void deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
    }*/


}
