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
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach(projects::add);
        return projects;
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
        //projectRepository.findById(id).orElse(null);
    }

    public void deleteProjectById(String id) {
        boolean exists = projectRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        projectRepository.deleteById(id);
    }

    /*public Project addEmployeeToProject(String id, Employee employee) {
        boolean exists = projectRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        if(!employeeRepository.existsById(employee.getId())) {//if employee is not exists in the employeeRepository --employee is new to employeeRepository
            employeeRepository.save(new Employee(employee.getName(),employee.getJobPosition()));//create new employee and add it to employeeRepository
        }
        if( employee.getProject()==null || employee.getProject().getId()!=id ) {//if employee is not assigned to any project or is assigned to different project
           // projectRepository.findById(id).get().getEmployees().add(employee);// add this employee to this project
            employee.setProject(projectRepository.findById(id).get());
        }
        //employee.setProject(projectRepository.findById(id).get());
        return projectRepository.findById(id).get();//return this project
    }*/
    public Project removeEmployeefromProject(String id, String employee_id) {
        boolean exists1 = projectRepository.existsById(id);
        boolean exists2 = employeeRepository.existsById(employee_id);

        if (!exists1) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        } else if (!exists2) {
            throw new IllegalStateException("Employee with id " + employee_id + " does not exists");
        }
        Employee employee=employeeRepository.findById(employee_id).get();
       //Project project=projectRepository.findById(id).get();
        if(employee.getProject().getId()==id) {
            employee.setProject(null);
        }
        return projectRepository.findById(id).get();
    }

    public Project addTaskToProject(String id, Task task) {
        boolean exists = projectRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        if(!taskRepository.existsById(task.getId())) {//if task is not exists in the taskRepository --task is new to taskRepository
            //Task task1=new Task(task.getName(),task.getDescription());
            task.generateId();
            List<Project> projects=new ArrayList<>();
          //  Project project=new Project(id,"","");
            //project.setId(id);
            projects.add(projectRepository.findById(id).get());
            task.setProjects(projects);
            taskRepository.save(task);//create new employee and add it to employeeRepository
        }
        Project project=projectRepository.findById(id).get();
        if(!project.getTasks().contains(task)) {//still not working in a right way
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
        //projectRepository.findById(id).get().getTasks().removeIf(task -> task.getId()==task_id);
        projectRepository.findById(id).get().getTasks().remove(taskRepository.findById(task_id).get());
        return projectRepository.findById(id).get();

    }

   /* public Project addTaskToProject(UUID id, UUID taskId) {
        boolean exists1 = projectRepository.existsById(id);
        boolean exists2 = taskRepository.existsById(taskId);
        if (!exists1) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        } else if (!exists2) {
            throw new IllegalStateException("Task with id " + taskId + " does not exists");
        }
        projectRepository.findById(id).get().getTasks().add(taskRepository.findById(taskId).get());
        return projectRepository.findById(id).orElse(null);
    }
    public Project removeTaskFromProject(UUID id, UUID taskId) {
        boolean exists1 = projectRepository.existsById(id);
        boolean exists2 = taskRepository.existsById(taskId);
        if (!exists1) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        } else if (!exists2) {
            throw new IllegalStateException("Task with id " + taskId + " does not exists");
        }
        projectRepository.findById(id).get().getTasks().remove(taskRepository.findById(taskId).get());
        return projectRepository.findById(id).orElse(null);
    }

    public Project addEmployeeToProject(UUID id, UUID employeeId) {
        boolean exists1 = projectRepository.existsById(id);
        boolean exists2 = employeeRepository.existsById(employeeId);
        if (!exists1) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        } else if (!exists2) {
            throw new IllegalStateException("Employee with id " + employeeId + " does not exists");
        }
        //Employee employee=employeeRepository.findById(employeeId).get();
        projectRepository.findById(id).get().getEmployees().add(employeeRepository.findById(employeeId).get());
        return projectRepository.findById(id).orElse(null);

    }*/
}

