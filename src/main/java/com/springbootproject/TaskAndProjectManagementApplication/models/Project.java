package com.springbootproject.TaskAndProjectManagementApplication.models;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.aerospike.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//@Entity
@Table(name = "projects")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Project.class)

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "projects_tasks",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") })
    private List<Task> tasks=new ArrayList<>();
     @OneToMany(mappedBy="project")
    private List<Employee> employees =new ArrayList<>();
    /*public Project() {
    }*/
    public String generateId(){
        this.id=UUID.randomUUID().toString();
        return this.id;
    }
}
