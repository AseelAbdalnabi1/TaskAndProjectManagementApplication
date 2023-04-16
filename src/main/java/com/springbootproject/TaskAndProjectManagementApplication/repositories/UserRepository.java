package com.springbootproject.TaskAndProjectManagementApplication.repositories;

import com.springbootproject.TaskAndProjectManagementApplication.models.Project;
import com.springbootproject.TaskAndProjectManagementApplication.models.User;
import org.springframework.data.aerospike.repository.AerospikeRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AerospikeRepository<User,String>{//, JpaRepository<User, String> {//JpaRepository<User,String> {
    Optional<User> findByUserName(String userName);
}
