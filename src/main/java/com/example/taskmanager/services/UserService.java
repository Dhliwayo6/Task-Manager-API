package com.example.taskmanager.services;

import com.example.taskmanager.model.User;

import com.example.taskmanager.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewTask(User user) {

        userRepository.save(user);
    }

    public void deleteTask(Long taskId) {
        userRepository.deleteById(taskId);
    }

    @Transactional
    public void updateUser(Long userId, String username) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("Task with id " + userId + "does not exist"));

        if (username != null && !username.isEmpty() && !Objects.equals(user.getUsername(), username)) {
            user.setUsername(username);
        }


    }
}

