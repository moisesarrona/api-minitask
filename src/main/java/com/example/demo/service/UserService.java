package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
public interface UserService {
    public List<User> getAllUser();

    public User findUser(Long id);

    public User createdUser(User user);

    public User updatedUser(User user);

    public void deletedUser(Long id);

    /*
     * @desc Custom methods for queries
     */
    public List<User> findUserByName(String userFullName);

    public User findUserByEmail(String userEmail);

}
