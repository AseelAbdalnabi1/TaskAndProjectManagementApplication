package com.springbootproject.TaskAndProjectManagementApplication.repositories;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
    public List<Task> findByName(String name);
}
