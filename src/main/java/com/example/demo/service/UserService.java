package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User findUser(Long id);
    public User createdUser(User user);
    public User updatedUser(User user);
    public void deletedUser(Long id);
}
