package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task findTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task createdTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updatedTask(Task task) {
        Task taskDB = findTask(task.getId());
        if (taskDB == null)
            return null;
        taskDB.setName(task.getName());
        taskDB.setDescription(task.getDescription());
        taskDB.setMode(task.getMode());
        taskDB.setStatus(task.getStatus());
        taskDB.setPriority(task.getPriority());
        return taskDB;
    }

    @Override
    public void deletedTask(Long id) {
        taskRepository.deleteById(id);
    }

    /*
     * @desc Custom methods for queries
     */
    @Override
    public List<Task> findAllTaskActiveByUserId(Long userId) {
        return taskRepository.findAllTaskActiveByUserId(userId);
    }

    @Override
    public List<Task> findTaskByStatusId(Long status_id) {
        return taskRepository.findTaskByStatusId(status_id);
    }

    @Override
    public List<Task> findTaskByPriorityId(Long priorityId) {
        return taskRepository.findTaskByPriorityId(priorityId);
    }

    @Override
    public List<Task> findAllTaskByName(String taskName) {
        return taskRepository.findAllTaskByName(taskName);
    }
}
