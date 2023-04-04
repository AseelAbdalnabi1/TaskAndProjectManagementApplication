package com.springbootproject.TaskAndProjectManagementApplication.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class AuthenticationRequest implements Serializable {
    private String username;
    private String password;
    public AuthenticationRequest(){}
    public AuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}