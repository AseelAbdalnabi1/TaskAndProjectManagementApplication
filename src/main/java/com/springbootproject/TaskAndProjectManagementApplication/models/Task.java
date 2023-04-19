package com.springbootproject.TaskAndProjectManagementApplication.models;

import com.aerospike.client.query.IndexType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.data.aerospike.annotation.Indexed;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Task.class)
//@Builder(toBuilder = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Task {
    @Id
    private String id;
    @Indexed(name = "taskName_idx", type = IndexType.STRING)
    private String taskName;
    private String description;
    private List<Project> projects=new ArrayList<>();
    private List<Employee> employees=new ArrayList<>();

    public String generateId(){
        this.id=UUID.randomUUID().toString();
        return this.id;
    }
}
