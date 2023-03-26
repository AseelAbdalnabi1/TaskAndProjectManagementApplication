package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.ProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;
    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public List<Project> findAllProjects(){
        return projectService.getAllProjects();
    }
    @GetMapping("/name/{name}")
    public List<Project> findProjectByName(@PathVariable String name){
        return projectService.findProjectByName(name);
    }
    @GetMapping("/id/{id}")
    public Project findProjectById(@PathVariable String id){
        return projectService.findProjectById(id);
    }
    @PostMapping()
    public Project createProject(@RequestBody Project project){//@RequestParam("name") String name,@RequestParam("description") String description){
        return projectService.createProject(project);
    }
    @PutMapping("/{id}")
    public Project updateProjectById(@RequestBody Project project,@PathVariable String id){
       return projectService.updateProjectById(project,id);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable String id){
      projectService.deleteProjectById(id);
    }
    /*@PostMapping("/id/{id}/employees/id/{employee-id}")
    public Project addEmployeeToProject(@PathVariable UUID id,@PathVariable("employee-id") UUID employee_id){
        return projectService.addEmployeeToProject(id,employee_id);
    }
    @PostMapping("/id/{id}/tasks/id/{task-id}")
    public Project addTaskToProject(@PathVariable UUID id,@PathVariable("task-id") UUID task_id){
        return projectService.addTaskToProject(id,task_id);
    }
    @DeleteMapping("/id/{id}/tasks/id/{task-id}")
    public Project removeTaskFromProject(@PathVariable UUID id,@PathVariable("task-id") UUID task_id){
        return projectService.removeTaskFromProject(id,task_id);
    }*/
   /* @PostMapping("/{id}/employees")
    public Project addEmployeeToProject(@PathVariable String id, @RequestBody Employee employee){
        return projectService.addEmployeeToProject(id,employee);
    }*/
/*    @DeleteMapping("/{id}/employees/id/{employee-id}")
    public Project removeEmployeefromProject(@PathVariable String id,@PathVariable("employee-id") String employee_id){
        return removeEmployeefromProject(id,employee_id);
    }*/
    //
    //@PostMapping("/tasks/{id}/project/{project-id}")//if we were in task controller
    @PostMapping("/{id}/tasks")
    public Project addTaskToProject(@PathVariable String id,@RequestBody Task task){
        return projectService.addTaskToProject(id,task);
    }
    @DeleteMapping("/{id}/tasks/{task_id}")
    public Project removeTaskFromProject(@PathVariable String id,@PathVariable String task_id){
        return projectService.removeTaskFromProject(id,task_id);
    }




}
