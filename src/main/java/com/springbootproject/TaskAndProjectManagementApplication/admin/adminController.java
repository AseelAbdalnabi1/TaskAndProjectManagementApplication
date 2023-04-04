package com.springbootproject.TaskAndProjectManagementApplication.admin;

import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/projects")
public class adminController {
    private ProjectService projectService;
    @Autowired
    public adminController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping
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
}
