package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.EmployeeRepository;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.ProjectRepository;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ProjectService {

    private ProjectRepository projectRepository;
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    private EmployeeRepository employeeRepository;
    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public TaskRepository taskRepository;
    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
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

    public Project addTaskToProject(String id, Task task) {
        boolean exists = projectRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        if(!taskRepository.existsById(task.getId())) {//if task is not exists in the taskRepository --task is new to taskRepository
            task.generateId();
            List<Project> projects=new ArrayList<>();
            projects.add(projectRepository.findById(id).get());
            task.setProjects(projects);
            taskRepository.save(task);//create new employee and add it to employeeRepository
        }
        Project project=projectRepository.findById(id).get();
        if(!project.getTasks().contains(task.getId())) {//still not working in a right way
            project.getTasks().add(taskRepository.findById(task.getId()).orElse(null));
        }
        return projectRepository.findById(id).get();
    }
    public Project removeTaskFromProject(String id, String task_id) {
        boolean exists1 = projectRepository.existsById(id);
        boolean exists2 = taskRepository.existsById(task_id);
        if (!exists1) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        } else if (!exists2) {
            throw new IllegalStateException("Task with id " + task_id + " does not exists");
        }
        projectRepository.findById(id).get().getTasks().remove(taskRepository.findById(task_id).get());
        return projectRepository.findById(id).get();
    }
}

