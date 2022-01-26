package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    static final String queryFindUserByName =
            "SELECT *FROM users WHERE CONCAT_WS(' ', name, lastname, username) LIKE %:userName%";

    static final String queryFindUserByEmail =
            "SELECT *FROM users WHERE email LIKE %:userEmail%";


    @Query(value = queryFindUserByName, nativeQuery = true)
    public List<User> findUserByName(@Param("userName") String userName);

    @Query(value = queryFindUserByEmail, nativeQuery = true)
    public User findUserByEmail(@Param("userEmail") String userEmail);

}
