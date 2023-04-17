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
        scope = Employee.class)
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data

@Document
public class Employee {

    @Id
    private String id;
    @Indexed(name = "employeeName_idx", type = IndexType.STRING)
    private String employeeName;
    private String jobPosition;

    private Project project;

    private List<Task> tasks=new ArrayList<>();
    public String generateId(){
        this.id=UUID.randomUUID().toString();
     return this.id;
    }
}
