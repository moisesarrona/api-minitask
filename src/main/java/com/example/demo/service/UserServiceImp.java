package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return userRepository.save(user);
    }

    @Override
    public User updatedUser(User user) {
        User userdb = findUser(user.getId());
        if (userdb == null) {
            return null;
        }
        userdb.setName(user.getName());
        userdb.setLastname(user.getLastname());
        userdb.setEmail(user.getEmail());
        userdb.setPhone(user.getPhone());
        userdb.setDescription(user.getDescription());
        return userRepository.save(userdb);
    }

    @Override
    public void deletedUser(Long id) {
        userRepository.deleteById(id);
    }
}
