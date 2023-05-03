package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Task> findAllTasks() throws Exception{
        List<Task> tasks=new ArrayList<>();
        try{
            tasks=taskService.findAllTasks();
        }catch (Exception e){
            throw new RuntimeException("There is no tasks");
        }
        return tasks;
        //return taskService.findAllTasks();
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task findTaskById(@PathVariable String id) throws Exception {
        Task task=null;
        try{
             task=taskService.findTaskById(id);
        }catch (Exception e){
            throw new RuntimeException("Task with id: "+id +" not found");
        }
        return task;
    }
    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Task> findTaskByName(@RequestParam(name = "name") String name) throws Exception{
        List<Task> tasks=new ArrayList<>();
        try{
            tasks=taskService.findTaskByName(name);
        }catch (Exception e){
            throw new RuntimeException("There is no tasks with the required name: " + name);
        }
        return tasks;
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
       Task createdTask=null;
        try{
            createdTask =taskService.createTask(task);
        }catch (Exception e){
            throw new RuntimeException("Task can NOT be created");
        }
        return createdTask;
      // return taskService.createTask(task);
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task updateTaskById(@RequestBody Task task,@PathVariable String id) throws Exception {
       Task updatedTask=null;
       try{
           updatedTask =taskService.updateTask(task,id);
       }catch (Exception e){
           throw new RuntimeException("Task can NOT be updated");
       }
        return updatedTask;
        // return taskService.updateTask(task,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTaskById(@PathVariable String id) throws Exception {
        try{
            taskService.deleteTaskById(id);
        }catch (Exception e){
            throw new RuntimeException("Task can NOT be deleted");
        }
        //taskService.deleteTaskById(id);
    }
}
