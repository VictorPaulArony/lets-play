package com.backend.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {
    private String id;
    private String username;
    private String email;
    private Role role;
    private String password;

    public enum Role{
        USER, ADMIN
    }
}
