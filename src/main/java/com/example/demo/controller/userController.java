package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users/")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAllUser();
        if (users == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUser(@PathVariable(value = "id") Long id) {
        User user = userService.findUser(id);
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User userCreated = userService.createdUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> updatedUser(@Valid @RequestBody User user, @PathVariable(value = "id") Long id) {
        User userUpdated = userService.updatedUser(user);
        if (userUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userUpdated);
    }

    @DeleteMapping
    public ResponseEntity<User> deletedUser(@PathVariable(value = "id") Long id) {
        User userDeleted = userService.findUser(id);
        if (userDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deletedUser(userDeleted.getId());
        return ResponseEntity.ok(userDeleted);
    }

}
