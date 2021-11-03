package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Priority;
import com.example.demo.service.PriorityService;

@RestController
@RequestMapping(value = "/api/priorities")
public class PriorityController {
	@Autowired
	private PriorityService priorityService;
	
	@GetMapping
	public ResponseEntity<List<?>> getAllPriority() {
		List<Priority> priorities = priorityService.getAllPriority();
		if (priorities == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(priorities);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getPriority (@PathVariable(value = "id") Long id) {
		Priority priority = priorityService.getPriority(id);
		if (priority == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(priority);
	}
	
	@PostMapping
	public ResponseEntity<?> createPriority(@Valid @RequestBody Priority priority) {
		Priority priorityCreated = priorityService.createPriority(priority);
		return ResponseEntity.status(HttpStatus.CREATED).body(priorityCreated);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updatePriority(@Valid @RequestBody Priority priority, @PathVariable(value = "id") Long id){
		Priority priorityUpdated = priorityService.updatePriority(priority);
		if (priorityUpdated == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(priorityUpdated);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePriority(@PathVariable(value = "id") Long id) {
		Priority priorityDeleted = priorityService.getPriority(id);
		if (priorityDeleted == null) {
			return ResponseEntity.notFound().build();
		}
		priorityService.deletePriority(id);
		return ResponseEntity.ok().build();
	}
}
