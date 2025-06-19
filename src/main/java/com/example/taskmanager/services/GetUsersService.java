package com.example.taskmanager.services;

import com.example.taskmanager.Query;
import com.example.taskmanager.model.User;
import com.example.taskmanager.model.UserDTO;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersService implements Query<Void, List<UserDTO>> {

    private UserRepository userRepository;

    public GetUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<UserDTO>> execute(Void input) {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream().map(UserDTO::new).toList();

        //no need for throwing exception here, just return an empty list
        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }
}
