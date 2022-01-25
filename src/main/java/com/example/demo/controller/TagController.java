package com.example.demo.controller;

import com.example.demo.entity.Tag;
import com.example.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tags/")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTag() {
        List<Tag> statuses = tagService.getAllTag();
        if (statuses == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statuses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tag> findStatus(@PathVariable(value = "id") Long id) {
        Tag tag = tagService.findTag(id);
        if (tag == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tag);
    }

    @PostMapping
    public ResponseEntity<Tag> createdTag(@Valid @RequestBody Tag tag) {
        Tag tagCreated = tagService.createdTag(tag);
        return ResponseEntity.status(HttpStatus.CREATED).body(tagCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tag> updatedTag(@Valid @RequestBody Tag tag, @PathVariable(value = "id") Long id) {
        Tag tagUpdated = tagService.updatedTag(tag);
        if (tagUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tagUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Tag> deletedTag(@PathVariable(value = "id") Long id){
        Tag tagDeleted = tagService.findTag(id);
        if (tagDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        tagService.deletedTag(id);
        return ResponseEntity.ok().build();
    }
}
