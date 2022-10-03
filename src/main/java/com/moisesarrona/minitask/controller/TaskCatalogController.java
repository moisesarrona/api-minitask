package com.moisesarrona.minitask.controller;

import com.moisesarrona.minitask.entity.Phase;
import com.moisesarrona.minitask.entity.Priority;
import com.moisesarrona.minitask.entity.Tag;
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
        List<Priority> prioritiesDB = taskCatalogService.findPrioritiesByName(name);
        if (prioritiesDB.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(prioritiesDB);
    }

    @PostMapping(value = "/createdPriority")
    public ResponseEntity<Priority> createdPriority(@Valid @RequestBody Priority priority) {
        Priority priorityDB = taskCatalogService.createdPriority(priority);
        return ResponseEntity.ok(priorityDB);
    }


    @RequestMapping(value = "/findPhaseById/{id}")
    public ResponseEntity<Phase> findPhaseById(@PathVariable("id") Long id) {
        Phase phaseDB = taskCatalogService.findPhaseById(id);
        if (phaseDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(phaseDB);
    }

    @RequestMapping(value = "/findPhaseByName/{name}")
    public ResponseEntity<List<Phase>> findPhaseByName(@PathVariable("name") String name) {
        List<Phase> phasesDB = taskCatalogService.findPhasesByName(name);
        if (phasesDB.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(phasesDB);
    }

    @PostMapping(value = "/createdPhase")
    public ResponseEntity<Phase> createdPhase(@Valid @RequestBody Phase phase) {
        Phase phaseDB = taskCatalogService.createdPhase(phase);
        return ResponseEntity.ok(phaseDB);
    }


    @RequestMapping(value = "/findTagById/{id}")
    public ResponseEntity<Tag> findTagById(@PathVariable("id") Long id) {
        Tag tagDB = taskCatalogService.findTagById(id);
        if (tagDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tagDB);
    }

    @RequestMapping(value = "/findTagsByName/{name}")
    public ResponseEntity<List<Tag>> findTagsByName(@PathVariable("name") String name) {
        List<Tag> tagsDB = taskCatalogService.findTagsByName(name);
        if (tagsDB.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(tagsDB);
    }

    @PostMapping(value = "/createdTag")
    public ResponseEntity<Tag> createdTag(@Valid @RequestBody Tag tag) {
        Tag tagsDB = taskCatalogService.createdTag(tag);
        return ResponseEntity.ok(tagsDB);
    }
}
