package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.User;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
public interface UserService {
    public User findUserById(Long id);

    public List<User> findUserByEmail(String email);

    public List<User> findUserByUsernameOrName(String user);

    public User createdUser(User user);

    public User updatedUser(User user);

    public User deletedUser(Long id);
}
