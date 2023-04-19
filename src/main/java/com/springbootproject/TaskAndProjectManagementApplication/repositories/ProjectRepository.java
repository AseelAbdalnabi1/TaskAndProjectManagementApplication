package com.springbootproject.TaskAndProjectManagementApplication.repositories;

import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository  extends AerospikeRepository<Project,String>{
    public List<Project> findByName(String name);
}
