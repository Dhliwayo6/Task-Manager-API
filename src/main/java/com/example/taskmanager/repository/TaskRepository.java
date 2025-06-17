package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {

//    @Query("SELECT u FROM Task u WHERE u.username = ?1")
//    Optional<Task>findByUsername(String username);
}