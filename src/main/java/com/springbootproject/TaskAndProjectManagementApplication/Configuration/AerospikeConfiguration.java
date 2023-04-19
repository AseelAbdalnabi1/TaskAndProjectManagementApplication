package com.springbootproject.TaskAndProjectManagementApplication.Configuration;


import com.aerospike.client.Host;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.config.AerospikeDataSettings;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableTransactionManagement
@EnableAerospikeRepositories(basePackages = "com.springbootproject.TaskAndProjectManagementApplication.repositories")
public class AerospikeConfiguration extends AbstractAerospikeDataConfiguration {
    @Override
    public Collection<Host> getHosts() {
        return Collections.singleton(new Host("localhost", 3000));

    }

    @Override
    protected String nameSpace() {
        return "projectManagement";
    }
    
    @Bean
    public AerospikeDataSettings aerospikeDataSettings() {
        return AerospikeDataSettings.builder().scansEnabled(true).build();
    }
}