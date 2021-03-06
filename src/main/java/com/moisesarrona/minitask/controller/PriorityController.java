package com.moisesarrona.minitask.controller;

import com.moisesarrona.minitask.entity.Priority;
import com.moisesarrona.minitask.errorhandler.InvalidDataException;
import com.moisesarrona.minitask.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
@RestController
@RequestMapping(value = "/api/priorities/")
public class PriorityController {
    @Autowired
    private PriorityService priorityService;

    @GetMapping(value = "/getAllPriority")
    public ResponseEntity<List<Priority>> getAllPriority() {
        List<Priority> priorities = priorityService.getAllPriority();
        if (priorities.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(priorities);
    }

    @GetMapping(value = "/findPriority/{id}")
    public ResponseEntity<Priority> findPriority(@PathVariable(value = "id") Long id) {
        Priority priority = priorityService.findPriority(id);
        if (priority == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(priority);
    }

    @PostMapping(value = "/createdPriority")
    public ResponseEntity<Priority> createdPriority(@Valid @RequestBody Priority priority, BindingResult result) {
        if (result.hasErrors())
            throw new InvalidDataException(result);
        Priority priorityCreated = priorityService.createdPriority(priority);
        return ResponseEntity.status(HttpStatus.CREATED).body(priorityCreated);
    }

    @PutMapping(value = "/updatedPriority/{id}")
    public ResponseEntity<Priority> updatedPriority(@Valid @RequestBody Priority priority, @PathVariable(value = "id") Long id, BindingResult result) {
        if (result.hasErrors())
            throw new InvalidDataException(result);
        Priority priorityUpdated = priorityService.updatedPriority(priority);
        if (priorityUpdated == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(priorityUpdated);
    }

    @DeleteMapping(value = "/deletedPriority/{id}")
    public ResponseEntity<Priority> deletedPriority(@PathVariable(value = "id") Long id) {
        Priority priority = priorityService.findPriority(id);
        if (priority == null)
            return ResponseEntity.notFound().build();
        priorityService.deletedPriority(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/findPriorityByName/{priorityName}")
    public ResponseEntity<List<Priority>> findPriorityByName(@PathVariable(value = "priorityName") String priorityName) {
        List<Priority> priorities = priorityService.findPriorityByName(priorityName);
        if (priorities.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(priorities);
    }
}
