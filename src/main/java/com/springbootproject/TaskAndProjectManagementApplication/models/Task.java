package com.springbootproject.TaskAndProjectManagementApplication.models;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.aerospike.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Task.class)

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Task {
    @Id
    private String id;
    private String name;
    private String description;
   @ManyToMany(
           cascade = {
                   CascadeType.PERSIST,
                   CascadeType.MERGE
           },mappedBy = "tasks")
    private List<Project> projects=new ArrayList<>();
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "tasks")
    private List<Employee> employees=new ArrayList<>();


    /*public Task() {
    }*/
    public String generateId(){
        this.id=UUID.randomUUID().toString();
        return this.id;
    }
}
