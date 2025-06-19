package com.example.taskmanager.model;

public class UpdateTaskCommand {

    private Integer id;
    private Task task;

    public UpdateTaskCommand(Integer id, Task task) {
        this.id = id;
        this.task = task;
    }

    public Integer getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }
}
