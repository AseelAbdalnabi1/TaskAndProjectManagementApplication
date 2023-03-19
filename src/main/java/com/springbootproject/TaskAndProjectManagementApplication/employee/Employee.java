package com.springbootproject.TaskAndProjectManagementApplication.employee;

import com.springbootproject.TaskAndProjectManagementApplication.project.Project;
import com.springbootproject.TaskAndProjectManagementApplication.task.Task;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {

    @Id
    private String id;
    private String name;
    private String jobPosition;
    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    /*  @OneToMany
        private List<Task> task;

        public List<Task> getTask() {
            return task;
        }

        public void setTask(List<Task> task) {
            this.task = task;
        }
    */
    public Employee() {
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Employee(String id, String name, String jobPosition) {
        this.id = id;
        this.name = name;
        this.jobPosition = jobPosition;
    }

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

}
