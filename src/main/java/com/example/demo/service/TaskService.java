package com.example.demo.service;

import com.example.demo.entity.Task;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTask();

    public Task findTask(Long id);

    public Task createdTask(Task task);

    public Task updatedTask(Task task);

    public void deletedTask(Long id);

    /*
     * @desc Custom methods for queries
     */
    public List<Task> findAllTaskByMode(Long user);

    public List<Task> findTaskByStatus(Long status);

    public List<Task> findTaskByPriority(Long priority);

    public List<Task> findTaskByName(@Param("name") String name);

}
