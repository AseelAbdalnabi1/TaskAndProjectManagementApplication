package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Task> findAllTasks(){
        return taskService.findAllTasks();
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task findTaskById(@PathVariable String id){
        return taskService.findTaskById(id);
    }
    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Task> findTaskByName(@RequestParam(name = "name") String name){
        return taskService.findTaskByName(name);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
       return taskService.createTask(task);
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task updateTaskById(@RequestBody Task task,@PathVariable String id){
        return taskService.updateTask(task,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTaskById(@PathVariable String id){
         taskService.deleteTaskById(id);
    }
}
