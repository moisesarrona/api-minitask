package com.example.demo.controller;

import com.example.demo.entity.Priority;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAllTasks () {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTask (@PathVariable(value = "id") Long id) {
        Task task = taskService.getTask(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }


    @PostMapping
    public ResponseEntity<?> createTask (@Valid @RequestBody Task task) {
        Task taskCreated = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateTask (@Valid @RequestBody Task task, @PathVariable(value = "id") Long id) {
        Task taskUpdated = taskService.updateTask(task);
        if (taskUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTask (@PathVariable(value = "id") Long id) {
        Task taskDeleted = taskService.getTask(id);
        if (taskDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
