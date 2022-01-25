package com.example.demo.repository;

import com.example.demo.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    static String findByName = "SELECT *FROM status WHERE name = :statusName";

    @Query(value = findByName, nativeQuery = true)
    public Status findByName(String statusName);
}
