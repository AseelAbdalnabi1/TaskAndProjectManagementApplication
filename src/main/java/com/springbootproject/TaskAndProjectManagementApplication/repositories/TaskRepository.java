package com.springbootproject.TaskAndProjectManagementApplication.repositories;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
   // public List<Task> findByProjectId(String projectId);
    //public List<Task> findByEmployeeId(String employeeId);
    public Optional<Task> findById(UUID id);

    public List<Task> findByName(String name);
    public Optional<Task> deleteById(UUID id);
    public boolean existsById(UUID id);
}
