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
@RequestMapping(value = "/api/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<?> getAllStatus () {
        List<Status> statuses = statusService.getAllStatus();
        if (statuses == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statuses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getStatus (@PathVariable(value = "id") Long id) {
        Status status = statusService.getStatus(id);
        if (status == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(status);
    }

    @PostMapping
    public ResponseEntity<?> createStatus (@Valid @RequestBody Status status) {
        Status statusCreated = statusService.createStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(statusCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updatedStatus (@Valid @RequestBody Status status, @PathVariable(value = "id") Long id) {
        Status statusDB = statusService.updateStatus(status);
        if (statusDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(statusDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStatus (@PathVariable(value = "id") Long id) {
        Status statusDelete = statusService.getStatus(id);
        if (statusDelete == null) {
            return ResponseEntity.notFound().build();
        }
        statusService.deteleStatus(id);
        return ResponseEntity.ok().build();
    }
}
