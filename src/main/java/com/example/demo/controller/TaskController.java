package com.example.demo.controller;

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

    @GetMapping(value = "/getAllTask")
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = taskService.getAllTask();
        if (tasks == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(value = "/findTask/{id}")
    public ResponseEntity<Task> findTask(@PathVariable(value = "id") Long id) {
        Task task = taskService.findTask(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping(value = "/createdTask")
    public ResponseEntity<Task> createdTask(@Valid @RequestBody Task task) {
        Task taskCreated = taskService.createdTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @PutMapping(value = "/updatedTask/{id}")
    public ResponseEntity<Task> updatedTask(@Valid @RequestBody Task task, @PathVariable(value = "id") Long id) {
        Task taskUpdated = taskService.updatedTask(task);
        if (taskUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskUpdated);
    }

    @DeleteMapping(value = "/deletedTask/{id}")
    public ResponseEntity<Task> deletedTask(@PathVariable(value = "id") Long id){
        Task taskDeleted = taskService.findTask(id);
        if (taskDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        taskService.deletedTask(id);
        return ResponseEntity.ok().build();
    }

    /*
     * @desc Custom methods for queries
     */
    @GetMapping(value = "/findAllTaskByMode/{user}")
    public ResponseEntity<List<Task>> findAllTaskByMode(@PathVariable(value = "user") Long user) {
        List<Task> task = taskService.findAllTaskByMode(user);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/findTaskByStatus/{status}")
    public ResponseEntity<List<Task>> findTaskByStatus(@PathVariable(value = "status") Long status) {
        List<Task> task = taskService.findTaskByStatus(status);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/findTaskByPriority/{priority}")
    public ResponseEntity<List<Task>> findTaskByPriority(@PathVariable(value = "priority") Long priority) {
        List<Task> task = taskService.findTaskByPriority(priority);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/findTaskByName/{name}")
    public ResponseEntity<List<Task>> findTaskByName(@PathVariable(value = "name") String name) {
        List<Task> task = taskService.findTaskByName(name);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }
}
