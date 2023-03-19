package com.springbootproject.TaskAndProjectManagementApplication.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public List<Task> getAllTasksInProject(String projectId){
        List<Task> tasks = new ArrayList<>();
        taskRepository.findByProjectId(projectId)
                .forEach(tasks::add);
        return tasks;
    }
    public List<Task> getAllTasksToEmployee(String employeeId){
        List<Task> tasks = new ArrayList<>();
        taskRepository.findByEmployeeId(employeeId)
                .forEach(tasks::add);
        return tasks;
    }

    public Optional<Task> getTask(String id){
         return taskRepository.findById(id);
    }
    public void addTask(Task task){
        taskRepository.save(task);
    }
    public void updateTask(Task task,String id){
        if(taskRepository.findById(id).isPresent()){
            taskRepository.save(task);
        }
    }
    public void deleteTask(String id){
        taskRepository.deleteById(id);
    }


}
