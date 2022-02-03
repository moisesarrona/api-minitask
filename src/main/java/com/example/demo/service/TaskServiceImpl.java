package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //Task taskDB = findTask(task.getId());
        //if (taskDB == null) {
            return taskRepository.save(task);
        //}
        //return taskDB;
    }

    @Override
    public Task updatedTask(Task task) {
        Task taskDB = findTask(task.getId());
        if (taskDB == null) {
            return null;
        }
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
    public List<Task> findAllTaskByMode(Long user) {
        return taskRepository.findAllTaskByMode(user);
    }

    @Override
    public List<Task> findTaskByStatus(Long status) {
        return taskRepository.findTaskByStatus(status);
    }

    @Override
    public List<Task> findTaskByPriority(Long priority) {
        return taskRepository.findTaskByPriority(priority);
    }

    @Override
    public List<Task> findTaskByName(String name) {
        return taskRepository.findTaskByName(name);
    }
}
