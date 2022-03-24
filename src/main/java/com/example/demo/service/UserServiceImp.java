package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createdUser(User user) {
        User userDB = userRepository.searchUserByUserName(user.getUsername());
        if (userDB == null)
            return userRepository.save(user);
        return userDB;
    }

    @Override
    public User updatedUser(User user) {
        User userDB = findUser(user.getId());
        if (userDB == null)
            return null;
        userDB.setName(user.getName());
        userDB.setLastname(user.getLastname());
        userDB.setEmail(user.getEmail());
        userDB.setPhone(user.getPhone());
        userDB.setDescription(user.getDescription());
        return userRepository.save(userDB);
    }

    @Override
    public void deletedUser(Long id) {
        userRepository.deleteById(id);
    }

    /*
     * @desc Custom methods for queries
     */
    @Override
    public List<User> findUserByName(String userFullName) {
        return userRepository.findUserByName(userFullName);
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return userRepository.findUserByEmail(userEmail);
    }

}
