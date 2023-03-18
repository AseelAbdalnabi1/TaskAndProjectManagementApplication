package com.springbootproject.TaskAndProjectManagementApplication.project;
import com.springbootproject.TaskAndProjectManagementApplication.task.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class Project {
    @Id
    private String id;
    private String name;
    private String description;

    @OneToMany(mappedBy="project")
    private List<Task> task;
   // @OneToMany
    //private Employee employee;
    public String getId() {
        return id;
    }

    public Project(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

}
