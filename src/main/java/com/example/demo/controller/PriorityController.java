package com.example.demo.controller;

import com.example.demo.entity.Priority;
import com.example.demo.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/priorities/")
public class PriorityController {
    @Autowired
    private PriorityService priorityService;

    @GetMapping
    public ResponseEntity<List<Priority>> getAllPriority() {
        List<Priority> priorities = priorityService.getAllPriority();
        if (priorities == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(priorities);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Priority> findPriority(@PathVariable(value = "id") Long id) {
        Priority priority = priorityService.findPriority(id);
        if (priority == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(priority);
    }

    @PostMapping
    public ResponseEntity<Priority> createdPriority(@Valid @RequestBody Priority priority) {
        Priority priorityCreated = priorityService.createdPriority(priority);
        return ResponseEntity.status(HttpStatus.CREATED).body(priorityCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Priority> updatedPriority(@Valid @RequestBody Priority priority, @PathVariable(value = "id") Long id) {
        Priority priorityUpdated = priorityService.updatedPriority(priority);
        if (priorityUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(priorityUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Priority> deletedPriority(@PathVariable(value = "id") Long id) {
        Priority priority = priorityService.findPriority(id);
        if (priority == null) {
            return ResponseEntity.notFound().build();
        }
        priorityService.deletedPriority(id);
        return ResponseEntity.ok().build();
    }
}
