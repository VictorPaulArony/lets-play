package com.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByRole(String role);
    Optional<User> findByEmail(String email);

}
