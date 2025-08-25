package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskDTO;
import com.example.taskmanager.model.UpdateTaskCommand;
import com.example.taskmanager.services.task.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final CreateTaskService createTaskService;
    private final GetTaskService getTaskService;
    private final GetTasksService getTasksService;
    private final UpdateTaskService updateTaskService;
    private final DeleteTaskService deleteTaskService;

    public TaskController(CreateTaskService createTaskService,
                          GetTaskService getTaskService,
                          GetTasksService getTasksService,
                          UpdateTaskService updateTaskService,
                          DeleteTaskService deleteTaskService) {
        this.createTaskService = createTaskService;
        this.getTaskService = getTaskService;
        this.getTasksService = getTasksService;
        this.updateTaskService = updateTaskService;
        this.deleteTaskService = deleteTaskService;
    }

    @PostMapping("/task")
    public ResponseEntity<TaskDTO> createProduct(@RequestBody Task task){
        return createTaskService.execute(task);
    }

    @GetMapping("tasks")
    public ResponseEntity<List<TaskDTO>> getProducts(){
        return getTasksService.execute(null);
    }

    //new get mapping to find by id

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDTO> getProductById(@PathVariable Integer id) {
        return getTaskService.execute(id);
    }

    //Search functionality request

//    @GetMapping("/task/search")
//    public ResponseEntity<List<TaskDTO>> searchTaskByName(@RequestParam String name) {
//        return searchTaskService.execute(name);
//    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskDTO> updateProduct(@PathVariable Integer id, @RequestBody Task task){
        return updateTaskService.execute(new UpdateTaskCommand(id, task));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        return deleteTaskService.execute(id);
    }
}

