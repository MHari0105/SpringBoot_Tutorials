package com.myproject.springjwtsecurity.security.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myproject.springjwtsecurity.security.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    
    Optional<User> findByMailId(String mailId);
    
}
