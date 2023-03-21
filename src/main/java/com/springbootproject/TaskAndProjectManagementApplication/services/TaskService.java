package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public List<Task> findAllTasks(){
            return taskRepository.findAll();
    }
    public Task findTaskById(UUID id){
         return taskRepository.findById(id).orElse(null);
    }
    public List<Task> findTaskByName(String name) {
        return taskRepository.findByName(name);
    }
    public Task addTask(Task task){
        taskRepository.save(task);
        return taskRepository.findById(task.getId()).get();
    }
    public Task updateTask(Task task,UUID id){
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("task with id "+ id +" does not exists");
        }
        taskRepository.save(task);
        return taskRepository.findById(task.getId()).get();
    }
    public void deleteTaskById(UUID id){
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("task with id "+ id +" does not exists");
        }

        taskRepository.deleteById(id);
    }



}
