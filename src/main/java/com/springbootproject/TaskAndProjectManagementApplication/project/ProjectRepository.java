package com.springbootproject.TaskAndProjectManagementApplication.project;

import com.springbootproject.TaskAndProjectManagementApplication.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository  extends JpaRepository<Project,String> {
}
