package com.springbootproject.TaskAndProjectManagementApplication.services;


import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {
    private TaskRepository taskRepository;
    private static final Logger logger= LoggerFactory.getLogger(TaskService.class);
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> findAllTasks() throws Exception {
        logger.info("finding all tasks");
        List<Task> tasks=taskRepository.findAll();
        if (tasks.isEmpty()) {
            throw new Exception();
        }
        return tasks;
         //return taskRepository.findAll();
    }
    public Task findTaskById(String id) {
        logger.info("finding task by id");
        return taskRepository.findById(id).get();
    }
    public List<Task> findTaskByName(String name) throws Exception {
        logger.info("finding tasks by name");
        List<Task> tasks=taskRepository.findByName(name);
        if (tasks.isEmpty()) {
            throw new Exception();
        }
        return tasks;
    }
    public Task createTask(Task task){
        logger.info("creating a task");
        task.generateId();
       return taskRepository.save(task);
    }
    public Task updateTask(Task task,String id) throws Exception {
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            logger.error("task does not exit");
            throw new Exception();
        }
        logger.info("updating the task");
       return taskRepository.save(task);
    }
    public void deleteTaskById(String id) throws Exception {
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            logger.error("task does not exit");
            throw new Exception();
        }
        logger.info("deleting the task");
        taskRepository.deleteById(id);
    }
}
