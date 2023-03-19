package com.springbootproject.TaskAndProjectManagementApplication.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployee(String projectId){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findByProjectId(projectId)
                .forEach(employees::add);
        return employees;
    }
    public Optional<Employee> getEmployee(String id){
        return employeeRepository.findById(id);
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
