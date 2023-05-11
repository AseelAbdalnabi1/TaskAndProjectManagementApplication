package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/tasks")
public class TaskController {
    private static final Logger logger= LoggerFactory.getLogger(TaskController.class);
    private TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task findTaskById(@PathVariable String id) throws Exception {
        return taskService.findTaskById(id);
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Task> findTaskByName(@RequestParam(name = "name") String name) throws Exception{
        return taskService.findTaskByName(name);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) throws Exception {
        return taskService.createTask(task);
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task updateTaskById(@RequestBody Task task,@PathVariable String id) throws Exception {
        return taskService.updateTask(task,id);
    }
}
