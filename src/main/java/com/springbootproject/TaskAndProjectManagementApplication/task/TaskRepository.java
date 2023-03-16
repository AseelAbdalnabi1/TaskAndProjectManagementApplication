package com.springbootproject.TaskAndProjectManagementApplication.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
    public List<Task> findByProjectId(String projectId);
}
