package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.EmployeeRepository;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.ProjectRepository;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private TaskRepository taskRepository;
    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    private ProjectRepository projectRepository;
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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

    public Employee addProjectToEmployee(String id, Project project) {
        boolean exists1 = employeeRepository.existsById(id);
        boolean exists2 = projectRepository.existsById(project.getId());
        if (!exists1) {
            throw new IllegalStateException("Employee with id " + id + " does not exists");
        }
       else if (!exists2) {
            throw new IllegalStateException("Project with id " + project.getId() + " does not exists");
        }
      //  projectRepository.save(project);
      /*  if(!projectRepository.existsById(project.getId())){//not working probably
            project.generateId();
            Employee employee=employeeRepository.findById(id).get();
            employee.setProject(project);
            projectRepository.save(project);



        }*/
        List<Employee> employees=new ArrayList<>();
        employees.add(employeeRepository.findById(id).get());
        project.setEmployees(employees);
        projectRepository.save(project);
        employeeRepository.findById(id).get().setProject(project);
        return employeeRepository.findById(id).orElse(null);

    }

    public Employee removeEmployeeFromProject(String id) {
        boolean exists1 = employeeRepository.existsById(id);
        if (!exists1) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        employeeRepository.findById(id).get().setProject(null);
        return employeeRepository.findById(id).orElse(null);
    }
    public Employee addTaskToEmployee(String id, Task task) {
        boolean exists1 = employeeRepository.existsById(id);

        if (!exists1) {
            throw new IllegalStateException("Employee with id " + id + " does not exists");
        }
        if(!taskRepository.existsById(task.getId())){
            task.generateId();
            List<Employee> employees=new ArrayList<>();
            employees.add(employeeRepository.findById(id).get());
            task.setEmployees(employees);
            taskRepository.save(task);
        }
        Employee employee =employeeRepository.findById(id).get();
        if(!employee.getTasks().contains(task)) {
            employeeRepository.findById(id).get().getTasks().add(taskRepository.findById(task.getId()).orElse(null));
        }

        return employeeRepository.findById(id).orElse(null);
    }

    public Employee removeTaskFromEmployee(String id,String task_id) {
        boolean exists1 = employeeRepository.existsById(id);
        boolean exists2 = taskRepository.existsById(task_id);
        if (!exists1) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }else if (!exists2) {
            throw new IllegalStateException("Task with id " + task_id + " does not exists");
        }
        employeeRepository.findById(id).get().getTasks().remove(taskRepository.findById(task_id).get());
        return employeeRepository.findById(id).get();

    }

    /*public Employee addEmployeeToProject(UUID id, UUID projectId) {
        boolean exists1 = projectRepository.existsById(projectId);
        boolean exists2 = employeeRepository.existsById(id);
        if (!exists1) {
            throw new IllegalStateException("Project with id " + projectId + " does not exists");
        } else if (!exists2) {
            throw new IllegalStateException("Employee with id " + id + " does not exists");
        }
         employeeRepository.findById(id).get().setProject(projectRepository.findById(projectId).get());
        //employeeRepository.findById(id).get().setProject(new Project(projectId,"",""));
        return employeeRepository.findById(id).orElse(null);

    }*/

    /*public Employee removeEmployeeFromProject(UUID id) {
        //boolean exists1 = projectRepository.existsById(projectId);
        boolean exists1 = employeeRepository.existsById(id);
        if (!exists1) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        } /*else if (!exists2) {
            throw new IllegalStateException("Employee with id " + id + " does not exists");
        }*/
   //     employeeRepository.findById(id).get().setProject(null);
     //   return employeeRepository.findById(id).orElse(null);
    //}
/*
    public Employee addTaskToEmployee(UUID id, UUID taskId) {
        boolean exists1 = employeeRepository.existsById(id);
        boolean exists2 = taskRepository.existsById(taskId);
        if (!exists1) {
            throw new IllegalStateException("Employee with id " + id + " does not exists");
        } else if (!exists2) {
            throw new IllegalStateException("Task with id " + taskId + " does not exists");
        }
        employeeRepository.findById(id).get().getTasks().add(new Task(taskId,"",""));//taskRepository.findById(taskId).get());
        return employeeRepository.findById(id).orElse(null);

    }*/

}
