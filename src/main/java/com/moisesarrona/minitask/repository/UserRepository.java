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
            "SELECT *FROM users WHERE id = :id";

    static final String queryFindUserByEmail =
            "SELECT *FROM users WHERE email LIKE %:email%";

    static final String queryFindUserByUsernameOrName =
            "SELECT *FROM users WHERE CONCAT_WS(' ', name, lastname, username) LIKE %:user%";


    @Query(value = queryFindUserById, nativeQuery = true)
    public User findUserById(@Param("id") Long id);

    @Query(value = queryFindUserByEmail, nativeQuery = true)
    public List<User> findUserByEmail(@Param("email") String email);

    @Query(value = queryFindUserByUsernameOrName, nativeQuery = true)
    public List<User> findUserByUsernameOrName(@Param("user") String user);
}
