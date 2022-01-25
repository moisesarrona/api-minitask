package com.example.demo.controller;

import com.example.demo.entity.Status;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/status/")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> getAllStatus() {
        List<Status> statuses = statusService.getAllStatus();
        if (statuses == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statuses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Status> findStatus(@PathVariable(value = "id") Long id) {
        Status status = statusService.findStatus(id);
        if (status == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(status);
    }

    @PostMapping
    public ResponseEntity<Status> createdStatus(@Valid @RequestBody Status status) {
        Status statusCreated = statusService.createdStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(statusCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Status> updatedStatus(@Valid @RequestBody Status status, @PathVariable(value = "id") Long id) {
        Status statusUpdated = statusService.updatedStatus(status);
        if (statusUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(statusUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Status> deletedStatus(@PathVariable(value = "id") Long id){
        Status statusDeleted = statusService.findStatus(id);
        if (statusDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        statusService.deletedStatus(id);
        return ResponseEntity.ok().build();
    }
}
