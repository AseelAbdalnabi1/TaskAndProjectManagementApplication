package com.springbootproject.TaskAndProjectManagementApplication.Configuration;


import com.aerospike.client.Host;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.EmployeeRepository;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.ProjectRepository;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.TaskRepository;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.config.AerospikeDataSettings;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableAerospikeRepositories(basePackageClasses = { EmployeeRepository.class, ProjectRepository.class, TaskRepository.class, UserRepository.class})
public class AerospikeConfiguration extends AbstractAerospikeDataConfiguration {
    @Override
    protected Collection<Host> getHosts() {
        return Collections.singleton(new Host("localhost", 3000));
    }

    @Override
    protected String nameSpace() {
        return "test";
    }

    @Bean
    public AerospikeDataSettings aerospikeDataSettings() {
        return AerospikeDataSettings.builder().scansEnabled(true).build();
    }
}