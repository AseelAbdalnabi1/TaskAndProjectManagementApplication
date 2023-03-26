package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public List<Task> findAllTasks(){
        return taskService.findAllTasks();
    }
    @GetMapping("/id/{id}")
    public Task findTaskById(@PathVariable String id){
        return taskService.findTaskById(id);
    }
    @GetMapping("/name/{name}")
    public List<Task> findTaskByName(@PathVariable String name){
        return taskService.findTaskByName(name);
    }
    @PostMapping()
    public Task createTask(@RequestBody Task task){//@RequestParam("name") String name,@RequestParam("description") String description){
       return taskService.createTask(task);
    }
    @PutMapping("/id/{id}")
    public Task updateTaskById(@RequestBody Task task,@PathVariable String id){
        return taskService.updateTask(task,id);
    }
    @DeleteMapping("/id/{id}")
    public void deleteTaskById(@PathVariable String id){
         taskService.deleteTaskById(id);
    }

}
