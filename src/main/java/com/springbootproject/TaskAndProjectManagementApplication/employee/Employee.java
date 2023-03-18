package com.springbootproject.TaskAndProjectManagementApplication.employee;

import com.springbootproject.TaskAndProjectManagementApplication.project.Project;
import com.springbootproject.TaskAndProjectManagementApplication.task.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {

    @Id
    private String id;
    private String name;
    private String jobPosition;

   // @ManyToMany
    //private Project project;
   /* @OneToMany
    private Task task;*/

    /*public Project getProjects() {
        return project;
    }

    /*public void setProjects(Project project) {
        this.project = project;
    }*/

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

   /* public Employee(String id, String name, String jobPosition, String taskId) {
        this.id = id;
        this.name = name;
        this.jobPosition = jobPosition;
        this.task = new Task(taskId,"","");
    }*/

    public Employee(String id, String name, String jobPosition) {
        this.id = id;
        this.name = name;
        this.jobPosition = jobPosition;
    }

   /* public Employee(String name, String id, String jobPosition, String projectId) {
        this.name = name;
        this.id = id;
        this.jobPosition= jobPosition;
        this.project=new Project(projectId,"","");
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }*/

  /*  public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }*/
}
