package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAllUser")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAllUser();
        if (users == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/findUser/{id}")
    public ResponseEntity<User> findUser(@PathVariable(value = "id") Long id) {
        User user = userService.findUser(id);
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/createdUser")
    public ResponseEntity<User> createdUser(@Valid @RequestBody User user) {
        User userCreated = userService.createdUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PutMapping(value = "/updatedUser/{id}")
    public ResponseEntity<User> updatedUser(@Valid @RequestBody User user, @PathVariable(value = "id") Long id) {
        User userUpdated = userService.updatedUser(user);
        if (userUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userUpdated);
    }

    @DeleteMapping(value = "/deletedUser/{id}")
    public ResponseEntity<User> deletedUser(@PathVariable(value = "id") Long id) {
        User userDeleted = userService.findUser(id);
        if (userDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deletedUser(userDeleted.getId());
        return ResponseEntity.ok().build();
    }

    /*
     * @desc Custom methods for queries
     */
    @GetMapping(value = "/findUserByName/{userFullName}")
    public ResponseEntity<List<User>> findUserByName(@PathVariable(value = "userFullName") String userName) {
        List<User> users = userService.findUserByName(userName);
        if (users == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/findUserByEmail/{userEmail}")
    public ResponseEntity<User> findUserByEmail(@PathVariable(value = "userEmail") String userEmail) {
        User user = userService.findUserByEmail(userEmail);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

}
