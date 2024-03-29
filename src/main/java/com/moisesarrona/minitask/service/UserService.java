package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.User;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
public interface UserService {
    public User findUserById(Long userId);

    public User findUserByEmailAndPassword(String email, String password);

    public User findUserByUsername(String username);

    public List<User> findUsersByEmail(String email);

    public List<User> findUsersByNameOrUsername(String user);

    public User createdUser(User user);

    public User updatedUser(User user);

    public User changeStatusUser(Long userId);
}
