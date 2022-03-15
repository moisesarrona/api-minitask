package com.example.demo.service;

import com.example.demo.entity.Task;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
public interface TaskService {
    public List<Task> getAllTask();

    public Task findTask(Long id);

    public Task createdTask(Task task);

    public Task updatedTask(Task task);

    public void deletedTask(Long id);

    /*
     * @desc Custom methods for queries
     */
    public List<Task> findAllTaskActiveByUserId(Long user_id);

    public List<Task> findTaskByStatusId(Long status_id);

    public List<Task> findTaskByPriorityId(Long priority_id);

    public List<Task> findAllTaskByName(String taskName);

}
