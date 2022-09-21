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


    @RequestMapping(value = "/findUserById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User userDB = userService.findUserById(id);
        if (userDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDB);
    }

    @RequestMapping(value = "/findUserByEmail/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email){
        User userDB = userService.findUserByEmail(email).get(0);
        if (userDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDB);
    }

    @RequestMapping(value = "/findUserByUsernameOrName/{user}")
    public ResponseEntity<List<User>> findUserByUsernameOrName(@PathVariable("user") String user) {
        List<User> usersDB = userService.findUserByUsernameOrName(user);
        if (usersDB.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(usersDB);
    }

    @PostMapping(value = "/createdUser")
    public ResponseEntity<User> createdUser(@RequestBody User user) {
        user.setStatus(true);
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

    @PutMapping(value = "/deletedUser/{id}")
    public ResponseEntity<User> deletedUser(@PathVariable("id") Long id){
        User userDB = userService.deletedUser(id);
        if (userDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDB);
    }
}
