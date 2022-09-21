package com.moisesarrona.minitask.service;

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
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> findUserByUsernameOrName(String user) {
        return userRepository.findUserByUsernameOrName(user);
    }

    @Override
    public User createdUser(User user) {
        User userDB = findUserByEmail(user.getEmail()).get(0);
        if (userDB == null)
            return userRepository.save(user);
        return userDB;
    }

    @Override
    public User updatedUser(User user) {
        User userDB = findUserByEmail(user.getEmail()).get(0);
        if (userDB == null)
            return null;
        userDB.setName(user.getName());
        userDB.setLastname(user.getLastname());
        userDB.setUsername(user.getUsername());
        userDB.setDescription(user.getDescription());
        userDB.setPhone(user.getPhone());
        userDB.setEmail(user.getEmail());
        userDB.setPassword(user.getPassword());
        return userRepository.save(userDB);
    }

    @Override
    public User deletedUser(Long id) {
        User userDB = findUserById(id);
        if (userDB == null)
            return null;
        userDB.setStatus(!userDB.getStatus());
        return userRepository.save(userDB);
    }
}
