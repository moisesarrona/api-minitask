package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.User;
import com.moisesarrona.minitask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    public List<User> findUsersByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public List<User> findUsersByNameOrUsername(String user) {
        return userRepository.findUsersByNameOrUsername(user);
    }

    @Override
    public User createdUser(User user) {
        User userDB = userRepository.findUserByUsername(user.getUsername());
        if (userDB != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This username" + user.getUsername() + " already exists");
        userDB = userRepository.findUserByEmail(user.getEmail());
        if (userDB != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This email" + user.getEmail() + " already exists");
        user.setStatus(true);
        return userRepository.save(user);
    }

    @Override
    public User updatedUser(User user) {
        User userDB = userRepository.findUserById(user.getId());
        if (userDB == null)
            return null;
        userDB.setName(user.getName());
        userDB.setLastname(user.getLastname());
        userDB.setBirthday(user.getBirthday());
        userDB.setUsername(user.getUsername());
        userDB.setImage(user.getImage());
        userDB.setDescription(user.getDescription());
        userDB.setPhone(user.getPhone());
        userDB.setLink(user.getLink());
        userDB.setEmail(user.getEmail());
        return userRepository.save(userDB);
    }

    @Override
    public User changeStatusUser(Long userId) {
        User userDB = userRepository.findUserById(userId);
        if (userDB == null)
            return null;
        userDB.setStatus(!userDB.getStatus());
        return userRepository.save(userDB);
    }
}
