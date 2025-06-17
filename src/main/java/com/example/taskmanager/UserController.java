package com.example.taskmanager;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.services.TaskService;
import com.example.taskmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "taskmanager")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping("users")
    public void newTask(@RequestBody User user) {
        userService.addNewTask(user);
    }

    @DeleteMapping(path="{user_id}")
    public void deleteTask(@PathVariable("user_id") Long taskId) {
        userService.deleteTask(taskId);
    }

    @PutMapping(path="{user_id}")
    public void updateTask(@PathVariable("user_id") Long taskId,
                           @RequestParam(required = false) String username) {
        userService.updateUser(taskId, username);
    }


}
