package com.springbootproject.TaskAndProjectManagementApplication.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @RequestMapping("/projects")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }
    @RequestMapping("/projects/{id}")
    public Optional<Project> getProject(String id){
        return projectService.getProject(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/projects")
    public void addProject(@RequestBody Project project){
        projectService.addProject(project);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/projects/{id}")
    public void updateProject(@RequestBody Project project,@PathVariable String id){
        projectService.updateProject(project,id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/projects/{id}")
    public void deleteProject(@PathVariable String id){
        projectService.deleteProject(id);
    }


}
