package com.springbootproject.TaskAndProjectManagementApplication.repositories;

import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository  extends JpaRepository<Project,String> {
    public List<Project> findByName(String name);
    //public Project deleteByName(String name);
    public Optional<Project>findById(UUID id);
    public Optional<Project> deleteById(UUID id);
    public boolean existsById(UUID id);
}
