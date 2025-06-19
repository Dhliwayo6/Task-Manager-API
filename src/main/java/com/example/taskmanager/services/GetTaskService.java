package com.example.taskmanager.services;

import com.example.taskmanager.Query;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskDTO;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTaskService implements Query<Integer, TaskDTO> {

    private TaskRepository taskRepository;

    public GetTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(Integer input) {

        Optional<Task> taskOptional = taskRepository.findById(input);

        if (taskOptional.isPresent()){
            return ResponseEntity.ok(new TaskDTO(taskOptional.get()));
        }

        // throw an exception in the future
        throw new IllegalArgumentException("Task not found");

    }
}
