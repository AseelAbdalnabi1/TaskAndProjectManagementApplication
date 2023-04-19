package com.springbootproject.TaskAndProjectManagementApplication.models;

import com.aerospike.client.query.IndexType;
import com.aerospike.mapper.annotations.AerospikeKey;
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
        scope = Project.class)

@Setter
@Getter
//@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Project {
    @Id
    @AerospikeKey
    private String id;
    @Indexed(name = "projectName_idx", type = IndexType.STRING)
    private String projectName;
    private String description;
    private List<Task> tasks = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    public String generateId(){
        this.id=UUID.randomUUID().toString();
        return this.id;
    }
}
