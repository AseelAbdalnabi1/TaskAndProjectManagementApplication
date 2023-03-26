package com.springbootproject.TaskAndProjectManagementApplication.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
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
    private String id;
    private String name;
    private String description;
   @ManyToMany(fetch = FetchType.LAZY,
           cascade = {
                   CascadeType.PERSIST,
                   CascadeType.MERGE
           },mappedBy = "tasks")
    private List<Project> projects=new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "tasks")
    private List<Employee> employees=new ArrayList<>();


    /*public Task( UUID id, String name, String description) {
        setId();
        //this.id = id;
        this.name = name;
        this.description = description;
    }
*/
    /*public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }*/

    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
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
    public String generateId(){
        this.id=UUID.randomUUID().toString();
        return this.id;

    }

}
