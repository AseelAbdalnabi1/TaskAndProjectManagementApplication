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
    public List<Task> findAllTasks(){
        logger.info("finding all tasks");
            return taskRepository.findAll();
    }
    public Task findTaskById(String id){
        logger.info("finding task by id");
         return taskRepository.findById(id).orElse(null);
    }
    public List<Task> findTaskByName(String name) {
        logger.info("finding tasks by name");
        return taskRepository.findByName(name);
    }
    public Task createTask(Task task){
        logger.info("creating a task");
        task.generateId();
       return taskRepository.save(task);
    }
    public Task updateTask(Task task,String id){
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            logger.error("task does not exit");
            throw new IllegalStateException("task with id "+ id +" does not exists");
        }
        logger.info("updating the task");
       return taskRepository.save(task);
    }
    public void deleteTaskById(String id){
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            logger.error("task does not exit");
            throw new IllegalStateException("task with id "+ id +" does not exists");
        }
        logger.info("deleting the task");
        taskRepository.deleteById(id);
    }
}
