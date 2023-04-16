package com.springbootproject.TaskAndProjectManagementApplication.repositories;

import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.models.User;
import org.springframework.data.aerospike.repository.AerospikeRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends AerospikeRepository<Task,String>{//, JpaRepository<Task, String> {//JpaRepository<Task,String> {
    public List<Task> findByName(String name);
}
