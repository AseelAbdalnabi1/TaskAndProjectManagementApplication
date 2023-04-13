package com.springbootproject.TaskAndProjectManagementApplication.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.aerospike.mapping.Document;

import java.util.UUID;

//@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class User {
    @Id
    private String id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;

    public String generateId() {
        this.id=UUID.randomUUID().toString();
        return this.id;
    }


}
