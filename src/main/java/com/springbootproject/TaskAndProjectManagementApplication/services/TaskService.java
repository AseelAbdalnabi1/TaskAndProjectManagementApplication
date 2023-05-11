package com.springbootproject.TaskAndProjectManagementApplication.services;


import com.springbootproject.TaskAndProjectManagementApplication.exceptions.TaskCanNotBeCreatedException;
import com.springbootproject.TaskAndProjectManagementApplication.exceptions.TaskNotDeletedException;
import com.springbootproject.TaskAndProjectManagementApplication.exceptions.TaskNotFoundException;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Task> findAllTasks() {
        logger.info("finding all tasks");
         return taskRepository.findAll();
    }
    public Task findTaskById(String id) throws Exception {
        logger.info("finding task by id");
        Task task;
        try{
            task=taskRepository.findById(id).get();
        }catch (Exception exception){
            throw new TaskNotFoundException("task with id : "+id+" is NOT found");
        }
        return task;
    }
    public List<Task> findTaskByName(String name) throws Exception {
        logger.info("finding tasks by name");
        List<Task> tasks = taskRepository.findByName(name);
            if (tasks.isEmpty()) {
                throw new TaskNotFoundException("There is NO tasks with the name:"+name);
            }
        return tasks;
    }
    public Task createTask(Task task) throws Exception{
        logger.info("creating a task");
        task.generateId();
        Task createdTask;
        try{
            createdTask= taskRepository.save(task);
        }catch (IllegalArgumentException  exception){
            throw new TaskCanNotBeCreatedException("task not created");
        }
        return createdTask;
    }
    public Task updateTask(Task task,String id) throws Exception {
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            logger.error("task does not exit");
            throw new TaskNotFoundException("Task with id: "+id+" Not found");
        }
        logger.info("updating the task");
       return taskRepository.save(task);
    }
    public void deleteTaskById(String id) throws Exception {
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            logger.error("task does not exit");
            throw new TaskNotFoundException("Task with id: "+id+" Not found");
        }
        logger.info("deleting the task");
        try {
            taskRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
          throw new TaskNotDeletedException("Task with id:"+id+" can Not be deleted");
        }
    }
}
