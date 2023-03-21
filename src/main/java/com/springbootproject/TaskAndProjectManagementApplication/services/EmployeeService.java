package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployee(String projectId){
       // List<Employee> employees = new ArrayList<>();
        return employeeRepository.findByProjectId(projectId);

       // return employees;
    }
    public Employee getEmployee(String id){
        return employeeRepository.findById(id).orElse(null);
    }
    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public void updateEmployee(String id,Employee employee){
        if(employeeRepository.findById(id).isPresent()) {
            employeeRepository.save(employee);
        }
    }
    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }
}
