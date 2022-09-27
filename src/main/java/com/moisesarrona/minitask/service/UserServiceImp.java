package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.Priority;
import com.moisesarrona.minitask.entity.User;
import com.moisesarrona.minitask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<User> findUsersByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public List<User> findUserByUsersByNameOrUsername(String user) {
        return userRepository.findUserByUsersByNameOrUsername(user);
    }

    @Override
    public User createdUser(User user) {
        User userDB = userRepository.findUserByUsername(user.getUsername());
        if (userDB != null)
            return userDB;
        userDB = userRepository.findUserByEmail(user.getEmail());
        if (userDB != null)
            return userDB;
        user.setStatus(true);
        return userRepository.save(user);
    }

    @Override
    public User updatedUser(User user) {
        User userDB = findUserById(user.getId());
        if (userDB == null)
            return null;
        userDB.setName(user.getName());
        userDB.setLastname(user.getLastname());
        userDB.setUsername(user.getUsername());
        userDB.setDescription(user.getDescription());
        userDB.setPhone(user.getPhone());
        userDB.setEmail(user.getEmail());
        return userRepository.save(userDB);
    }

    @Override
    public User deletedUser(Long userId) {
        User userDB = findUserById(userId);
        if (userDB == null)
            return null;
        userDB.setStatus(!userDB.getStatus());
        return userRepository.save(userDB);
    }
}
