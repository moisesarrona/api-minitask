package com.moisesarrona.minitask.repository;

import com.moisesarrona.minitask.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    static final String queryFindPriorityById =
            "SELECT *FROM priorities WHERE id = :id";

    static final String queryFindPriorityByName =
            "SELECT *FROM priorities WHERE LIKE %:name%";


    public Priority findPriorityById(@Param("id") Long id);

    public List<Priority> findPriorityByName(@Param("name") String name);
}
