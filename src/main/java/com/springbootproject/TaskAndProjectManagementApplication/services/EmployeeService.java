package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private TaskService taskService;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,TaskService taskService, ProjectService projectService) {
        this.employeeRepository = employeeRepository;
        this.taskService = taskService;
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee findEmployeeById(String id){
        return employeeRepository.findById(id).orElse(null);
    }
    public List<Employee> findEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }
    public Employee createEmployee(Employee employee){
        employee.generateId();
       return employeeRepository.save(employee);
    }
    public Employee updateEmployeeById(String id,Employee employee){
        boolean exists = employeeRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Employee with id "+ id +" does not exists");
        }
        return employeeRepository.save(employee);
    }
    public void deleteEmployeeById(String id){
        boolean exists = employeeRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Employee with id "+ id +" does not exists");
        }
        employeeRepository.deleteById(id);
    }
     public Employee attachTaskToEmployee(String id, String taskId) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee==null) {
            throw new IllegalStateException("Employee with id " + id + " does not exists");
        }
        Task task=taskService.findTaskById(taskId);
        if(task==null){
            throw new IllegalStateException("Task with id " + taskId + " does not exists");
        }
        if(!employee.getTasks().contains(task)) {//to remove duplication
            employee.getTasks().add(task);
        }
            return employee;
    }

    public Employee discardTaskFromEmployee(String id,String task_id) {
        Employee employee=employeeRepository.findById(id).orElse(null);
        Task task=taskService.findTaskById(task_id);
        if(employee==null){
            throw new IllegalStateException("Project with id " + id + " does not exists");//it should return response entity
        } else if (task==null) {
            throw new IllegalStateException("Task with id " + task_id + " does not exists");
        }
        employee.getTasks().remove(task);
        return employee;
    }

}
