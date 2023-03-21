package com.springbootproject.TaskAndProjectManagementApplication.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Task.class)
public class Task {
    @Id
    private UUID id;
    private String name;
    private String description;
   // @ManyToMany//many to many
    //@JoinColumn(name="project_id", nullable=false)
   @ManyToMany(fetch = FetchType.LAZY,
           cascade = {
                   CascadeType.PERSIST,
                   CascadeType.MERGE
           },mappedBy = "tasks")
    private List<Project> projects;
   //manyto many
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "tasks")
    private List<Employee> employees;



    public Task( String name, String description) {
        setId();
        this.name = name;
        this.description = description;
    }

    public Task() {
    }

    public UUID getId() {
        return id;
    }

    private void setId() {
        this.id = UUID.randomUUID();
    }
    public List<Project> getProject() {
        return projects;
    }

    public void setProject(List<Project> projects) {
        this.projects = projects;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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

}
