package com.springbootproject.TaskAndProjectManagementApplication.repositories;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    //public List<Employee> findByProjectId(String projectId);
    public Optional<Employee> findById(UUID id);
    public boolean existsById(UUID id);

    public void deleteById(UUID id);

    public List<Employee> findByName(String name);
}
