package com.springbootproject.TaskAndProjectManagementApplication.services;
import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.TaskRepository;
//import jakarta.transaction.Transactional;
//import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
public class TaskService {
    private TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> findAllTasks(){
        List<Task> tasks = new ArrayList<Task>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
            //return taskRepository.findAll();
    }
    public Task findTaskById(String id){
         return taskRepository.findById(id).orElse(null);
    }
    public List<Task> findTaskByName(String name) {
        return taskRepository.findByName(name);
    }
    public Task createTask(Task task){
        task.generateId();
       return taskRepository.save(task);
    }
    public Task updateTask(Task task,String id){
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("task with id "+ id +" does not exists");
        }
       return taskRepository.save(task);
    }
    public void deleteTaskById(String id){
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("task with id "+ id +" does not exists");
        }
        taskRepository.deleteById(id);
    }
}
