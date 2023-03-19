package com.springbootproject.TaskAndProjectManagementApplication.task;

import com.springbootproject.TaskAndProjectManagementApplication.employee.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.springbootproject.TaskAndProjectManagementApplication.project.*;
@Entity
public class Task {
    @Id
    private String id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project project;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Task(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
