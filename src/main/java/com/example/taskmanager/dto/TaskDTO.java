package com.example.taskmanager.dto;

import com.example.taskmanager.enums.Priority;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;

import java.time.LocalDate;
import java.util.Objects;

public class TaskDTO {

    private Integer id;
    private String task;
    private LocalDate dateCreated;
    private Boolean complete;
    private Priority priority;
    private String comments;
    private Integer userId;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.task = task.getTask();
        this.dateCreated = task.getDateCreated();
        this.complete = task.getComplete();
        this.priority = task.getPriority();
        this.comments = task.getComments();
        this.userId = task.getUser().getId();
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

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id) && Objects.equals(task, taskDTO.task) && Objects.equals(dateCreated, taskDTO.dateCreated) && Objects.equals(complete, taskDTO.complete) && priority == taskDTO.priority && Objects.equals(comments, taskDTO.comments) && Objects.equals(userId, taskDTO.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, dateCreated, complete, priority, comments, userId);
    }
}
