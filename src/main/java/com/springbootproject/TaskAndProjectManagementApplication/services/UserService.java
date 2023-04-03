package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.models.User;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user){
        user.generateId();
        user.setRoles("USER");
        user.setActive(true);
        return userRepository.save(user);
    }
}
