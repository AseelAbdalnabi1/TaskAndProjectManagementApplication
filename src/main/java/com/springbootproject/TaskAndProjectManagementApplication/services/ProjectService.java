package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.exceptions.TaskAttachmentToProjectException;
import com.springbootproject.TaskAndProjectManagementApplication.exceptions.TaskNotFoundException;
import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class ProjectService {
    private ProjectRepository projectRepository;
    private EmployeeService employeeService;
    private TaskService taskService;
    @Autowired
    public ProjectService(ProjectRepository projectRepository,@Lazy EmployeeService employeeService,TaskService taskService) {
        this.projectRepository = projectRepository;
        this.employeeService = employeeService;
        this.taskService = taskService;
    }

    public List<Project> getAllProjects() {
       return projectRepository.findAll();
    }

    public Project findProjectById(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    public List<Project> findProjectByName(String projectName) {
        return projectRepository.findByName(projectName);
    }

    public Project createProject(Project project) {
        project.generateId();
        return projectRepository.save(project);
    }

    public Project updateProjectById(Project project, String id) {
        boolean exists = projectRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        return projectRepository.save(project);
    }

    public void deleteProjectById(String id) {
        boolean exists = projectRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        projectRepository.deleteById(id);
    }

    public Project attachTaskToProject(String id, String taskId) throws Exception {
        Project project = projectRepository.findById(id).orElse(null);
        if (project==null) {
            throw new EntityNotFoundException("Project with id " + id + " does not exists");
        }
        Task task = taskService.findTaskById(taskId);
        if (task==null) {
            throw new TaskNotFoundException("Task with id " + taskId + " does not exists");
        }
        if(project.getTasks().contains(task)) {
            throw new TaskAttachmentToProjectException("Task with id: " + taskId + " is already attached to project with id: " + id );
        }else {
            project.getTasks().add(task);
        }
        return projectRepository.save(project);

    }

    public Project discardTaskFromProject(String id, String task_id ) throws Exception {
        Project project = projectRepository.findById(id).orElse(null);
        Task task = taskService.findTaskById(task_id);
        if (project==null) {
            throw new EntityNotFoundException("Project with id " + id + " does not exists");
        } else if (task==null) {
            throw new TaskNotFoundException("Task with id " + task_id + " does not exists");
        }
        if(!project.getTasks().contains(task)) {
            throw new TaskNotFoundException("Task with id: " + task_id + " is Not attached to project with id: " + id );
        }else {
            project.getTasks().remove(task);
        }
        return projectRepository.save(project);
    }

    public Project attachEmployeeToProject(String id, String employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        Project project = projectRepository.findById(id).orElse(null);
        if (employee==null) {
            throw new IllegalStateException("Employee with id " + employeeId + " does not exists");
        }
        else if (project==null) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        if(employee.getProject()!=project) {
            employee.setProject(project);
        }
        return projectRepository.save(project);
    }

    public Project discardEmployeeFromProject(String id, String employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        Project project = projectRepository.findById(id).orElse(null);
        if (employee==null) {
            throw new IllegalStateException("Employee with id " + employeeId + " does not exists");
        }
        else if (project==null) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        if(employee.getProject()==project) {
            employee.setProject(null);
        }
        return projectRepository.save(project);
    }
}


