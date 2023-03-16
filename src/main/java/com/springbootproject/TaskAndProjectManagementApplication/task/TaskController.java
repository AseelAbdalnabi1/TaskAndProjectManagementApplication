package com.springbootproject.TaskAndProjectManagementApplication.task;

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
    public List<Task> getAllTasks(@PathVariable String projectId){
        return taskService.getAllTasks(projectId);
    }
    @RequestMapping("/projects/{projectId}/tasks/{id}")
    public Optional<Task> getTask(@PathVariable String id){
        return taskService.getTask(id);
    }
    @RequestMapping(method = RequestMethod.POST,value="/projects/{projectId}/tasks")
    public void addTask(@RequestBody Task task,@PathVariable String projectId){
        task.setProject(new Project(projectId,"",""));
        taskService.addTask(task);
    }
    @RequestMapping(method = RequestMethod.PUT,value="/projects/{projectId}/tasks/{id}")
    public void updateTask(@RequestBody Task task,@PathVariable String projectId,@PathVariable String id){
        task.setProject(new Project(projectId,"",""));
        taskService.updateTask(task,id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/projects/{projectId}/tasks/{id}")
    public void deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
    }

}
