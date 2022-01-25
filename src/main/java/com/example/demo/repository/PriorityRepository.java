package com.example.demo.repository;

import com.example.demo.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    static String findByName = "SELECT *FROM priorities WHERE name = :priorityName";

    @Query(value = findByName, nativeQuery = true)
    public Priority findByName(String priorityName);
}
