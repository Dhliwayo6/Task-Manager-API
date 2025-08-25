package com.example.taskmanager.services.user;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.services.EmailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}