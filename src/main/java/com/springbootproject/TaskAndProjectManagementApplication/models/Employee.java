package com.springbootproject.TaskAndProjectManagementApplication.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employees")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Employee.class)
public class Employee {

    @Id
    private UUID id;

    public UUID getId() {
        return id;
    }

    private void setId() {
        this.id = UUID.randomUUID();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    private String name;
    private String jobPosition;

   /* @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "employees")*/
   @ManyToOne
   @JoinColumn(name="project_id", nullable=true)
    private Project project;
    //@ManyToMany(mappedBy = "employee")
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "employees_tasks",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") })
    private List<Task> tasks;

    public Employee(String name, String jobPosition) {
        setId();
        this.name = name;
        this.jobPosition = jobPosition;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }



        public List<Task> getTask() {
            return tasks;
        }

        public void setTask(List<Task> task) {
            this.tasks = task;
        }

    public Employee() {
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
