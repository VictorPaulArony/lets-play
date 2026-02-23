package com.backend.service;

import org.springframework.stereotype.Service;

import com.backend.dto.UserDto;
import com.backend.entity.User;
import com.backend.repository.UserRepository;

@Service
public class UserRegistration {

    private final UserRepository userRepository;

    public UserRegistration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        //validate user details
        if(user.getUsername() == null || user.getUsername().trim().isEmpty()){
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if(user.getEmail() == null || !user.getEmail().contains("@")){
            throw new IllegalArgumentException("Invalid email address");
        }
        if(user.getPassword() == null || user.getPassword().length() < 6){
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        //check if user already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException(
                "User with this email already exists: " + user.getEmail());
        }
        //save user to database
        userRepository.save(user);
    }

    public UserDto userLogin(String email, String password) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("user not found: " + email));

            if (!user.getPassword().equals(password)){
                throw new IllegalArgumentException("Invalid user password");
            }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        
        return userDto;
    }

}
