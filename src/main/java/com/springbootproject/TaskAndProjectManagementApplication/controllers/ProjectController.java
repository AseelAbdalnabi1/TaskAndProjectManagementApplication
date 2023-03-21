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
   // @RequestMapping("/projects")
    @GetMapping()
    public List<Project> findAllProjects(){
        return projectService.getAllProjects();
    }
   // @RequestMapping("/projects/{id}")
    @GetMapping("/name/{name}")
    public List<Project> findProjectByName(@PathVariable String name){
        return projectService.findProjectByName(name);
    }
    @GetMapping("/id/{id}")
    public Project findProjectById(@PathVariable UUID id){
        return projectService.findProjectById(id);
    }

    //@RequestMapping(method = RequestMethod.POST,value = "/projects")
    @PostMapping()
    public Project addProject(@RequestParam("name") String name,@RequestParam("description") String description){
        return projectService.addProject(new Project(name,description));
    }
    //@RequestMapping(method = RequestMethod.PUT,value = "/projects/{id}")
    @PutMapping("/id/{id}")
    public Project updateProjectById(@RequestBody Project project,@PathVariable UUID id){
       return projectService.updateProjectById(project,id);
    }
    /*@PutMapping("/name/{name}")
    public Project updateProjectByName(@RequestBody Project project,@PathVariable String name){
        projectService.updateProjectByName(project,name);
        return project;
    }*/
    //@RequestMapping(method = RequestMethod.DELETE,value = "/projects/{id}")
    @DeleteMapping("/id/{id}")
    public void deleteProjectById(@PathVariable UUID id){
      projectService.deleteProjectById(id);
    }
    /*@DeleteMapping("/name/{name}")
    public void deleteProjectByName(@PathVariable String name){
        projectService.deleteProjectByName(name);
    }*/


}
