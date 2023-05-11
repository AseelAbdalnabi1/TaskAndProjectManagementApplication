package com.springbootproject.TaskAndProjectManagementApplication.controllers.admin;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/tasks")
public class TaskAdminController {
    private TaskService taskService;
    @Autowired
    public TaskAdminController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Task> findAllTasks() throws Exception {
        return taskService.findAllTasks();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTaskById(@PathVariable String id) throws Exception {
        taskService.deleteTaskById(id);
    }
}
