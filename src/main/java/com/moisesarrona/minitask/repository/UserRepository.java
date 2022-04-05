package com.moisesarrona.minitask.repository;

import com.moisesarrona.minitask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    static final String queryFindUserByName =
            "SELECT *FROM users WHERE CONCAT_WS(' ', name, lastname, username) LIKE %:userName%";

    static final String queryFindUserByEmail =
            "SELECT *FROM users WHERE email LIKE %:userEmail%";

    static final String querySearchUserByUserName =
            "SELECT *FROM users WHERE username = :userName";


    @Query(value = queryFindUserByName, nativeQuery = true)
    public List<User> findUserByName(@Param("userName") String userName);

    @Query(value = queryFindUserByEmail, nativeQuery = true)
    public User findUserByEmail(@Param("userEmail") String userEmail);

    @Query(value = querySearchUserByUserName, nativeQuery = true)
    public User searchUserByUserName(@Param("userName") String userName);

}
