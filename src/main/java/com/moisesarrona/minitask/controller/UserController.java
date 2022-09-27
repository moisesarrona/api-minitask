package com.moisesarrona.minitask.controller;

import com.moisesarrona.minitask.entity.User;
import com.moisesarrona.minitask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@RequestMapping(value = "/api/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/findUserById/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId") Long userId){
        User userDB = userService.findUserById(userId);
        if (userDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDB);
    }

    @RequestMapping(value = "/findUserByEmail/{email}")
    public ResponseEntity<List<User>> findUsersByEmail(@PathVariable("email") String email){
        List<User> userDB = userService.findUsersByEmail(email);
        if (userDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDB);
    }

    @RequestMapping(value = "/findUserByUsersByNameOrUsername/{user}")
    public ResponseEntity<List<User>> findUserByUsersByNameOrUsername(@PathVariable("user") String user) {
        List<User> usersDB = userService.findUserByUsersByNameOrUsername(user);
        if (usersDB.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(usersDB);
    }

    @PostMapping(value = "/createdUser")
    public ResponseEntity<User> createdUser(@RequestBody User user) {
        User userDB = userService.createdUser(user);
        return ResponseEntity.ok(userDB);
    }

    @PutMapping(value = "/updatedUser")
    public ResponseEntity<User> updatedUser(@RequestBody User user) {
        User userDB = userService.updatedUser(user);
        if (userDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDB);
    }

    @PutMapping(value = "/deletedUser/{userId}")
    public ResponseEntity<User> deletedUser(@PathVariable("userId") Long userId){
        User userDB = userService.deletedUser(userId);
        if (userDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDB);
    }
}
