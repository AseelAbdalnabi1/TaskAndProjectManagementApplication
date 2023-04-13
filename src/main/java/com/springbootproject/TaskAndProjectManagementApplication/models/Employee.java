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
@Table(name = "employees")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Employee.class)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Employee {
    @Id
    private String id;
    private String name;
    private String jobPosition;

   @ManyToOne
   @JoinColumn(name="project_id", nullable=true)
    private Project project;
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "employees_tasks",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") })
    private List<Task> tasks=new ArrayList<>();
   /* public Employee() {
    }*/
    public String generateId(){
        this.id=UUID.randomUUID().toString();
     return this.id;
    }
}
