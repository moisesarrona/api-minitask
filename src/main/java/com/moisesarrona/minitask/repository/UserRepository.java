package com.moisesarrona.minitask.repository;

import com.moisesarrona.minitask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    static final String queryFindUserById =
            "SELECT *FROM users WHERE id = :userId";

    static final String queryFindUserByEmail =
            "SELECT *FROM users WHERE email = :email";

    static final String queryFindUserByUsername =
            "SELECT *FROM users WHERE username = :username";

    static final String queryFindUsersByEmail =
            "SELECT *FROM users WHERE email LIKE %:email%";

    static final String queryFindUsersByNameOrUsername =
            "SELECT *FROM users WHERE CONCAT_WS(' ', name, lastname, username) LIKE %:user%";


    @Query(value = queryFindUserById, nativeQuery = true)
    public User findUserById(@Param("userId") Long userId);

    @Query(value = queryFindUserByEmail, nativeQuery = true)
    public User findUserByEmail(@Param("email") String email);

    @Query(value = queryFindUserByUsername, nativeQuery = true)
    public User findUserByUsername(@Param("username") String username);

    @Query(value = queryFindUsersByEmail, nativeQuery = true)
    public List<User> findUsersByEmail(@Param("email") String email);

    @Query(value = queryFindUsersByNameOrUsername, nativeQuery = true)
    public List<User> findUsersByNameOrUsername(@Param("user") String user);
}
