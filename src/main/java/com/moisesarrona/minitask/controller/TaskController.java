package com.moisesarrona.minitask.controller;

import com.moisesarrona.minitask.entity.Task;
import com.moisesarrona.minitask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/findAllTaskByDate/{idUser}/{dateStart}/{dateEnd}")
    public ResponseEntity<List<Task>> findAllTaskByDate(@PathVariable("idUser") Long idUser, @PathVariable("dateStart") Date dateStart,
                                                        @PathVariable("dateEnd")Date dateEnd) {
        List<Task> tasksDB = taskService.findAllTaskByDate(idUser, dateStart, dateEnd);
        if (tasksDB.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tasksDB);
    }

    @RequestMapping(value = "/findAllTaskByPriority/{idUser}/{priorityId}")
    public ResponseEntity<List<Task>> findAllTaskByPriority(@PathVariable("idUser") Long idUser, @PathVariable("priorityId") Long priorityId) {
        List<Task> tasksDB = taskService.findAllTaskByPriority(idUser, priorityId);
        if (tasksDB.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tasksDB);
    }

    @RequestMapping(value = "/findAllTaskByPhase/{idUser}/{statusId}")
    public ResponseEntity<List<Task>> findAllTaskByPhase(@PathVariable("idUser") Long idUser, @PathVariable("statusId") Long statusId) {
        List<Task> tasksDB = taskService.findAllTaskByPhase(idUser, statusId);
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

    @PutMapping(value = "/deletedTask/{idTask}")
    public ResponseEntity<Task> deletedTask(@PathVariable("idTask") Long idTask) {
        Task taskDB = taskService.deletedTask(idTask);
        if (taskDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taskDB);
    }

}
