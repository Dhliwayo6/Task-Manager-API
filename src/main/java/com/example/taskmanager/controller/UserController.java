package com.example.taskmanager.controller;

import com.example.taskmanager.model.UpdateUserCommand;
import com.example.taskmanager.model.User;
import com.example.taskmanager.model.UserDTO;
import com.example.taskmanager.services.user.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final CreateUserService createUserService;
    private final GetUserService getUserService;
    private final GetUsersService getUsersService;
    private final DeleteUserService deleteUserService;
    private final UpdateUserService updateUserService;

    public UserController(CreateUserService createUserService,
                          GetUserService getUserService,
                          GetUsersService getUsersService,
                          DeleteUserService deleteUserService,
                          UpdateUserService updateUserService,
                          UserService userService) {
        this.createUserService = createUserService;
        this.getUserService = getUserService;
        this.getUsersService = getUsersService;
        this.deleteUserService = deleteUserService;
        this.updateUserService = updateUserService;
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentuser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentuser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> users() {
        List<User> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return createUserService.execute(user);
    }

//    @GetMapping("users")
//    public ResponseEntity<List<UserDTO>> getUsers(){
//        return getUsersService.execute(null);
//    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        return getUserService.execute(id);
    }

    //Search functionality request

//    @GetMapping("/user/search")
//    public ResponseEntity<List<UserDTO>> searchUserByName(@RequestParam String name) {
//        return searchUserService.execute(name);
//    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody User user){
        return updateUserService.execute(new UpdateUserCommand(id, user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        return deleteUserService.execute(id);
    }

}

