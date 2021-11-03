package com.example.demo.service;

import com.example.demo.entity.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();

    public Task getTask(Long id);

    public Task createTask(Task task);

    public Task updateTask(Task task);

    public void deleteTask(Long id);
}
