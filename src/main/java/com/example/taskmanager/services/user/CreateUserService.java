//package com.example.taskmanager.services.user;
//
//import com.example.taskmanager.Command;
//import com.example.taskmanager.dto.UserDTO;
//import com.example.taskmanager.model.User;
//import com.example.taskmanager.repository.UserRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CreateUserService implements Command<User, UserDTO> {
//
//    private UserRepository userRepository;
//
//    public CreateUserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public ResponseEntity<UserDTO> execute(User user) {
//
//        User userSaved = userRepository.save(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(userSaved));
//    }
//}
