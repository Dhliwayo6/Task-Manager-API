package com.example.demo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {

        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Transactional
    public void updateTask(Long taskId, String username, String toDoList, String comments) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Task with id " + taskId + "does not exist"));

        if (username != null && username.length() > 0 && !Objects.equals(task.getUsername(), username)) {
            task.setUsername(username);
        }

        if (toDoList != null && toDoList.length() > 0 && !Objects.equals(task.getToDoList(), toDoList)) {
            task.setToDoList(toDoList);
        }

        if (comments != null && comments.length() > 0 && !Objects.equals(task.getComments(), comments)) {
            task.setComments(comments);
        }
    }
}
