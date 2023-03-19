package com.springbootproject.TaskAndProjectManagementApplication.employee;

import com.springbootproject.TaskAndProjectManagementApplication.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    public List<Employee> findByProjectId(String projectId);
}
