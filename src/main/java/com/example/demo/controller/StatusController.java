package com.example.demo.controller;

import com.example.demo.entity.Status;
import com.example.demo.errorhandler.InvalidDataException;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping(value = "/getAllStatus")
    public ResponseEntity<List<Status>> getAllStatus() {
        List<Status> statuses = statusService.getAllStatus();
        if (statuses == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statuses);
    }

    @GetMapping(value = "/findStatus/{id}")
    public ResponseEntity<Status> findStatus(@PathVariable(value = "id") Long id) {
        Status status = statusService.findStatus(id);
        if (status == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/createdStatus")
    public ResponseEntity<Status> createdStatus(@Valid @RequestBody Status status, BindingResult result) {
        if (result.hasErrors())
            throw new InvalidDataException(result);
        Status statusCreated = statusService.createdStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(statusCreated);
    }

    @PutMapping(value = "/updatedStatus/{id}")
    public ResponseEntity<Status> updatedStatus(@Valid @RequestBody Status status, @PathVariable(value = "id") Long id) {
        Status statusUpdated = statusService.updatedStatus(status);
        if (statusUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(statusUpdated);
    }

    @DeleteMapping(value = "/deletedStatus/{id}")
    public ResponseEntity<Status> deletedStatus(@PathVariable(value = "id") Long id){
        Status statusDeleted = statusService.findStatus(id);
        if (statusDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        statusService.deletedStatus(id);
        return ResponseEntity.ok().build();
    }

    /*
     * @desc Custom methods for queries
     */
    @GetMapping(value = "/findStatusByName/{statusName}")
    public ResponseEntity<List<Status>> findStatusByName(@PathVariable(value = "statusName") String statusName) {
        List<Status> status = statusService.findStatusByName(statusName);
        if (status == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(status);
    }
}
