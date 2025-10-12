package com.example.taskmanager.dto;

import com.example.taskmanager.model.User;

import java.util.Objects;

public class UserDTO {

    private Integer id;
    private String username;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(username, userDTO.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
