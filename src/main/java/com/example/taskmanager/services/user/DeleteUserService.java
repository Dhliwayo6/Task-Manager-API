//package com.example.taskmanager.services.user;
//
//import com.example.taskmanager.Command;
//import com.example.taskmanager.model.User;
//import com.example.taskmanager.repository.UserRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class DeleteUserService implements Command<Integer, Void> {
//
//    private UserRepository userRepository;
//
//    public DeleteUserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public ResponseEntity<Void> execute(Integer id) {
//        Optional<User> userOptional = userRepository.findById(id);
//        if (userOptional.isPresent()) {
//            userRepository.deleteById(id);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//
//        throw new IllegalArgumentException("User not found");
////        throw new ProductNotFoundException();
//    }
//}
