package com.springbootproject.TaskAndProjectManagementApplication.controllers;

import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.services.ProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @GetMapping()
    public List<Project> findAllProjects(){
        return projectService.getAllProjects();
    }
    @GetMapping("/name/{name}")
    public List<Project> findProjectByName(@PathVariable String name){
        return projectService.findProjectByName(name);
    }
    @GetMapping("/id/{id}")
    public Project findProjectById(@PathVariable UUID id){
        return projectService.findProjectById(id);
    }
    @PostMapping()
    public Project addProject(@RequestParam("name") String name,@RequestParam("description") String description){
        return projectService.addProject(new Project(name,description));
    }
    @PutMapping("/id/{id}")
    public Project updateProjectById(@RequestBody Project project,@PathVariable UUID id){
       return projectService.updateProjectById(project,id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteProjectById(@PathVariable UUID id){
      projectService.deleteProjectById(id);
    }



}
