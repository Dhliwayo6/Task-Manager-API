package com.example.taskmanager;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/taskmanager")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<Task> getTasks() {
        return this.taskService.getTasks();
    }

    @PostMapping("tasks")
    public void newTask(@RequestBody Task task) {
        taskService.addNewTask(task);
    }

    @DeleteMapping(path="{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PutMapping(path="{taskId}")
    public void updateTask(@PathVariable("taskId") Long taskId,
                           @RequestParam(required = false) String username,
                           @RequestParam(required = false) String toDoList,
                           @RequestParam(required = false) String comments) {
        taskService.updateTask(taskId, username, toDoList, comments);
    }


}
