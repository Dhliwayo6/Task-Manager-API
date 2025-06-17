package com.example.taskmanager.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "toDoList", nullable = false, length = 255)
    private String toDoList;

    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @Column(name = "comments", nullable = true)
    private String comments;

    public Task() {
        this.dateCreated = LocalDate.now();
    }

    public Task(Long id, String username, String toDoList, String comments) {
        this.id = id;
        this.username = username;
        this.toDoList = toDoList;
        this.dateCreated = LocalDate.now();
        this.comments = comments;
    }

    public Task(String username, String toDoList, String comments) {
        this.username = username;
        this.dateCreated = LocalDate.now();
        this.toDoList = toDoList;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getDate() {
        return dateCreated;
    }

    public void setDate(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getToDoList() {
        return toDoList;
    }

    public void setToDoList(String toDoList) {
        this.toDoList= toDoList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", to_do_list='" + toDoList + '\'' +
                ", date=" + dateCreated +
                ", comments='" + comments + '\'' +
                '}';
    }
}
