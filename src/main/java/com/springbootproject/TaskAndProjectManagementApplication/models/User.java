package com.springbootproject.TaskAndProjectManagementApplication.models;

import com.springbootproject.TaskAndProjectManagementApplication.repositories.UserRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

@Entity
@Table(name = "users")
@Setter
@Getter
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
