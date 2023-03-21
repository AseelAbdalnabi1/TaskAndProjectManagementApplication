package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach(projects::add);
        return projects;
    }

    public Project findProjectById(UUID id) {
        return projectRepository.findById(id).orElse(null);
    }

    public List<Project> findProjectByName(String projectName) {
        return projectRepository.findByName(projectName);
    }

    public Project addProject(Project project) {
        projectRepository.save(project);
        return projectRepository.findById(project.getId()).get();
    }

    public Project updateProjectById(Project project, UUID id) {
        boolean exists = projectRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        projectRepository.save(project);
        return projectRepository.findById(id).orElse(null);
    }

    public void deleteProjectById(UUID id) {
        boolean exists = projectRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Project with id " + id + " does not exists");
        }
        projectRepository.deleteById(id);
    }
}

