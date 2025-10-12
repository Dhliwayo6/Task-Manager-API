package com.example.taskmanager.dto;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;

import java.time.LocalDate;
import java.util.Objects;

public class TaskDTO {

    private Integer id;
    private String task;
    private LocalDate dateCreated;
    private String comments;
    private User user;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.task = task.getTask();
        this.dateCreated = task.getDateCreated();
        this.comments = task.getComments();
        this.user = task.getUser();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id) && Objects.equals(task, taskDTO.task) && Objects.equals(dateCreated, taskDTO.dateCreated) && Objects.equals(comments, taskDTO.comments) && Objects.equals(user, taskDTO.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, dateCreated, comments, user);
    }
}
