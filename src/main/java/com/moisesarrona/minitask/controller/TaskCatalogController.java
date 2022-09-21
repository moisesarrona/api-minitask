package com.moisesarrona.minitask.controller;

import com.moisesarrona.minitask.entity.Priority;
import com.moisesarrona.minitask.entity.Status;
import com.moisesarrona.minitask.service.TaskCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@RequestMapping(value = "/api/taskCatalog")
@RestController
public class TaskCatalogController {
    @Autowired
    private TaskCatalogService taskCatalogService;


    @RequestMapping(value = "/findPriorityById/{id}")
    public ResponseEntity<Priority> findPriorityById(@PathVariable("id") Long id) {
        Priority priorityBD = taskCatalogService.findPriorityById(id);
        if (priorityBD == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(priorityBD);
    }

    @RequestMapping(value = "/findPriorityByName/{name}")
    public ResponseEntity<List<Priority>> findPriorityByName(@PathVariable("name") String name) {
        List<Priority> prioritiesDB = taskCatalogService.findPriorityByName(name);
        if (prioritiesDB.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(prioritiesDB);
    }

    @PostMapping(value = "/createdPriority")
    public ResponseEntity<Priority> createdPriority(@Valid @RequestBody Priority priority) {
        Priority priorityDB = taskCatalogService.createdPriority(priority);
        return ResponseEntity.ok(priorityDB);
    }


    @RequestMapping(value = "/findStatusById/{id}")
    public ResponseEntity<Status> findStatusById(Long id) {
        Status statusDB = taskCatalogService.findStatusById(id);
        if (statusDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusDB);
    }

    @RequestMapping(value = "/findStatusByName/{name}")
    public ResponseEntity<List<Status>> findStatusByName(String name) {
        List<Status> statusDB = taskCatalogService.findStatusByName(name);
        if (statusDB.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(statusDB);
    }

    @PostMapping(value = "/createdStatus")
    public ResponseEntity<Status> createdStatus(@Valid @RequestBody Status status) {
        Status statusDB = taskCatalogService.createdStatus(status);
        return ResponseEntity.ok(statusDB);
    }
}
