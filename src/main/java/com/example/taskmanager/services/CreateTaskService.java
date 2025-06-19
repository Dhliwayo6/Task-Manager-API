package com.example.taskmanager.services;

import com.example.taskmanager.Command;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskDTO;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService implements Command<Task, TaskDTO> {

    private TaskRepository taskRepository;

    public CreateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(Task task) {

        Task taskSaved = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TaskDTO(taskSaved));
    }
}
