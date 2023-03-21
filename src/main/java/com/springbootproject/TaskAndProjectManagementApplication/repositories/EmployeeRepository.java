package com.springbootproject.TaskAndProjectManagementApplication.repositories;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    public List<Employee> findByProjectId(String projectId);
}
