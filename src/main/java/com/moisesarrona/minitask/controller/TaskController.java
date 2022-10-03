package com.moisesarrona.minitask.controller;

import com.moisesarrona.minitask.entity.Task;
import com.moisesarrona.minitask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author moisesarrona
 * @version 0.2
 */
@RequestMapping(value = "/api/tasks")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/findAllTasksByDate/{userId}/{dateStart}/{dateEnd}")
    public ResponseEntity<List<Task>> findAllTaskByDate(@PathVariable("userId") Long userId, @PathVariable("dateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateStart,
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("dateEnd")Date dateEnd) {
        List<Task> tasksDB = taskService.findAllTasksByDate(userId, dateStart, dateEnd);
        if (tasksDB.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tasksDB);
    }

    @RequestMapping(value = "/findAllTaskByPriority/{userId}/{priorityId}")
    public ResponseEntity<List<Task>> findAllTasksByPriority(@PathVariable("userId") Long idUser, @PathVariable("priorityId") Long priorityId) {
        List<Task> tasksDB = taskService.findAllTasksByPriority(idUser, priorityId);
        if (tasksDB.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tasksDB);
    }

    @RequestMapping(value = "/findAllTaskByPhase/{idUser}/{statusId}")
    public ResponseEntity<List<Task>> findAllTasksByPhase(@PathVariable("idUser") Long idUser, @PathVariable("statusId") Long statusId) {
        List<Task> tasksDB = taskService.findAllTasksByPhase(idUser, statusId);
        if (tasksDB.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tasksDB);
    }

    @PostMapping(value = "/createdTask")
    public ResponseEntity<Task> createdTask(@RequestBody Task task) {
        Task taskDB = taskService.createdTask(task);
        return ResponseEntity.ok(task);

    }

    @PutMapping(value = "/updatedTask")
    public ResponseEntity<Task> updatedTask(@RequestBody Task task) {
        Task taskDB = taskService.updatedTask(task);
        if (taskDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taskDB);
    }

    @PutMapping(value = "/deletedTask/{taskId}")
    public ResponseEntity<Task> deletedTask(@PathVariable("idTask") Long idTask) {
        Task taskDB = taskService.deletedTask(idTask);
        if (taskDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taskDB);
    }
}
