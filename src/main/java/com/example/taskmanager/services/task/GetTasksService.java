package com.example.taskmanager.services.task;

import com.example.taskmanager.Query;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskDTO;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTasksService implements Query<Void, List<TaskDTO>> {

    private TaskRepository taskRepository;

    public GetTasksService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<List<TaskDTO>> execute(Void input) {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOS = tasks.stream().map(TaskDTO::new).toList();

        //no need for throwing exception here, just return an empty list
        return ResponseEntity.status(HttpStatus.OK).body(taskDTOS);
    }
}
