package com.example.taskmanager.services.task;

import com.example.taskmanager.Command;
import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.model.UpdateTaskCommand;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateTaskService implements Command<UpdateTaskCommand, TaskDTO> {

    private TaskRepository taskRepository;

    public UpdateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(UpdateTaskCommand command) {
        Optional<Task> taskOptional = taskRepository.findById(command.getId());
        if (taskOptional.isPresent()) {
            Task task = command.getTask();
            task.setId(command.getId());

            taskRepository.save(task);
            return ResponseEntity.ok(new TaskDTO(task));
        }

        throw new TaskNotFoundException();

    }
}
