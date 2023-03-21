package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee findEmployeeById(UUID id){
        return employeeRepository.findById(id).orElse(null);
    }
    public List<Employee> findEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }
    public Employee addEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }
    public Employee updateEmployeeById(UUID id,Employee employee){
        boolean exists = employeeRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Employee with id "+ id +" does not exists");
        }
        employeeRepository.save(employee);
        return employee;
    }
    public void deleteEmployeeById(UUID id){
        boolean exists = employeeRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Employee with id "+ id +" does not exists");
        }
        employeeRepository.deleteById(id);
    }
}
