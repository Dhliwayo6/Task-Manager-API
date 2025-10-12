package com.example.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "task", nullable = false, length = 255)
    private String task;

    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @Column(name = "comments", nullable = true)
    private String comments;

    @ManyToOne(fetch = FetchType.EAGER)  // ← Change to EAGER
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"password", "verificationCode", "verificationExpiry",
            "authorities", "accountNonExpired", "accountNonLocked",
            "credentialsNonExpired", "enabled"})
    private User user;

    public Task() {
        this.dateCreated = LocalDate.now();
    }

    public Task(Integer id, User user, String task, String comments) {
        this.id = id;
        this.user = user;
        this.task = task;
        this.dateCreated = LocalDate.now();
        this.comments = comments;
    }

    public Task(User user, String task, String comments) {
        this.user = user;
        this.dateCreated = LocalDate.now();
        this.task = task;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
