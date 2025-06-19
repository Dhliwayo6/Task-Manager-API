package com.example.taskmanager.model;

public class UpdateUserCommand {

    private Integer id;
    private User user;

    public UpdateUserCommand(Integer id, User user) {
        this.id = id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
