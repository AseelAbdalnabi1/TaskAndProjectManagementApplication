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
    public List<Project> findProjectByName(@RequestParam(name = "name") String name){
        return projectService.findProjectByName(name);
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Project findProjectById(@PathVariable String id){
        return projectService.findProjectById(id);
    }
}
