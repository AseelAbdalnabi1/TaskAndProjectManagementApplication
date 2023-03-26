package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.services.ProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(code = HttpStatus.OK)
    public List<Project> findAllProjects(){
        return projectService.getAllProjects();
    }
    @GetMapping("/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Project> findProjectByName(@PathVariable String name){
        return projectService.findProjectByName(name);
    }
    @GetMapping("/id/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Project findProjectById(@PathVariable String id){
        return projectService.findProjectById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Project createProject(@RequestBody Project project){//@RequestParam("name") String name,@RequestParam("description") String description){
        return projectService.createProject(project);
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Project updateProjectById(@RequestBody Project project,@PathVariable String id){
       return projectService.updateProjectById(project,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProjectById(@PathVariable String id){
      projectService.deleteProjectById(id);
    }

    @PostMapping("/{id}/tasks")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Project addTaskToProject(@PathVariable String id,@RequestBody Task task){
        return projectService.addTaskToProject(id,task);
    }
    @DeleteMapping("/{id}/tasks/{task_id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Project removeTaskFromProject(@PathVariable String id,@PathVariable String task_id){
        return projectService.removeTaskFromProject(id,task_id);
    }
}
