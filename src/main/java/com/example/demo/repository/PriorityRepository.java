package com.example.demo.repository;

import com.example.demo.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    static final String queryFindPriorityByName =
            "SELECT *FROM priorities WHERE name LIKE %:priorityName%";

    static final String querySearchPriorityByName =
            "SELECT *FROM priorities WHERE name = :priorityName";

    @Query(value = queryFindPriorityByName, nativeQuery = true)
    public List<Priority> findPriorityByName(@Param("priorityName") String priorityName);

    @Query(value = querySearchPriorityByName, nativeQuery = true)
    public Priority searchPriorityByName(@Param("priorityName") String priorityName);
}
