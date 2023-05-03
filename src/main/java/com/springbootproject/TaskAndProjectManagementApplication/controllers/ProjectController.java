package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Project> findAllProjects(){
        return projectService.getAllProjects();
    }
    @GetMapping("/")// the / to differentiate between paths
    @ResponseStatus(code = HttpStatus.OK)
    public List<Project> findProjectByName(@RequestParam(name = "name") String name){
        return projectService.findProjectByName(name);
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Project findProjectById(@PathVariable String id){
        return projectService.findProjectById(id);
    }

    @PutMapping("/{id}/attach/tasks/{task-id}")//the attach to differentiate between paths
    @ResponseStatus(code = HttpStatus.OK)
    public Project attachTaskToProject(@PathVariable String id,@PathVariable("task-id") String taskId) throws Exception{
        return projectService.attachTaskToProject(id,taskId);
    }
    @PutMapping("/{id}/discard/tasks/{task-id}")//the attach to differentiate between paths
    @ResponseStatus(code = HttpStatus.OK)
    public Project discardTaskFromProject(@PathVariable String id,@PathVariable("task-id") String taskId) throws Exception{
        return projectService.discardTaskFromProject(id,taskId);

    }

    @PutMapping("/{project-id}/attach/employees/{employee-id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Project attachEmployeeToProject(@PathVariable("project-id") String id,@PathVariable("employee-id") String employeeId){
        return projectService.attachEmployeeToProject(id,employeeId);
    }
    @PutMapping("/{project-id}/discard/employees/{employee-id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Project discardEmployeeFromProject(@PathVariable(name = "project-id") String id,@PathVariable(name ="employee-id") String employeeId){
        return projectService.discardEmployeeFromProject(id,employeeId);
    }
}
