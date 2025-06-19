package com.example.taskmanager.services;

import com.example.taskmanager.Command;
import com.example.taskmanager.model.UpdateUserCommand;
import com.example.taskmanager.model.UserDTO;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDTO> {

    private UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserDTO> execute(UpdateUserCommand command) {
        Optional<User> userOptional = userRepository.findById(command.getId());
        if (userOptional.isPresent()) {
            User user = command.getUser();
            user.setId(command.getId());
//            ProductValidator.execute(product);
            userRepository.save(user);
            return ResponseEntity.ok(new UserDTO(user));
        }
//        throw new UserNotFoundException();

        throw new IllegalArgumentException("User not found");
    }
}
