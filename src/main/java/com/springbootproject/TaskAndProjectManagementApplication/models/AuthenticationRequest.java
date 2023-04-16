package com.springbootproject.TaskAndProjectManagementApplication.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class AuthenticationRequest implements Serializable {
    private String userName;
    private String password;
    public AuthenticationRequest(){}
    public AuthenticationRequest(String username, String password) {
        this.setUserName(username);
        this.setPassword(password);
    }
}