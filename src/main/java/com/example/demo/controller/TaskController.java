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
    @GetMapping(value = "/findAllTaskActiveByUserId/{user_id}")
    public ResponseEntity<List<Task>> findAllTaskActiveByUserId(@PathVariable(value = "user_id") Long user_id) {
        List<Task> task = taskService.findAllTaskActiveByUserId(user_id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/findTaskByStatusId/{status_id}")
    public ResponseEntity<List<Task>> findTaskByStatusId(@PathVariable(value = "status_id") Long status_id) {
        List<Task> task = taskService.findTaskByStatusId(status_id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/findTaskByPriorityId/{priority_id}")
    public ResponseEntity<List<Task>> findTaskByPriorityId(@PathVariable(value = "priority_id") Long priority_id) {
        List<Task> task = taskService.findTaskByPriorityId(priority_id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/findAllTaskByName/{taskName}")
    public ResponseEntity<List<Task>> findAllTaskByName(@PathVariable(value = "taskName") String taskName) {
        List<Task> task = taskService.findAllTaskByName(taskName);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }
}
