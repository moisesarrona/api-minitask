package com.moisesarrona.minitask.repository;

import com.moisesarrona.minitask.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    static final String queryFindStatusById =
            "SELECT *FROM status WHERE id = :id";

    static final String queryFindStatusByName =
            "SELECT *FROM status WHERE LIKE %:name%";


    public Status findStatusById(@Param("id") Long id);

    public List<Status> findStatusByName(@Param("name") String name);
}
