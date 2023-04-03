package com.springbootproject.TaskAndProjectManagementApplication;

import com.springbootproject.TaskAndProjectManagementApplication.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class TaskAndProjectManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskAndProjectManagementApplication.class, args);
	}

}
