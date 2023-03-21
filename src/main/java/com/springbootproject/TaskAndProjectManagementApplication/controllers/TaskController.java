package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping()
    public List<Task> findAllTasks(){
        return taskService.findAllTasks();
    }
    @GetMapping("/id/{id}")
    public Task findTaskById(@PathVariable UUID id){
        return taskService.findTaskById(id);
    }
    @GetMapping("/name/{name}")
    public List<Task> findTaskByName(@PathVariable String name){
        return taskService.findTaskByName(name);
    }
    @PostMapping()
    public Task addTask(@RequestParam("name") String name,@RequestParam("description") String description){
       return taskService.addTask(new Task(name,description));
    }
    @PutMapping("/id/{id}")
    public Task updateTaskById(@RequestBody Task task,@PathVariable UUID id){
        return taskService.updateTask(task,id);
    }
    @DeleteMapping("/id/{id}")
    public void deleteTaskById(@PathVariable UUID id){
         taskService.deleteTaskById(id);
    }

}
