package com.example.demo.repository;

import com.example.demo.entity.Status;
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
public interface StatusRepository extends JpaRepository<Status, Long> {
    static final String queryFindStatusByName =
            "SELECT *FROM status WHERE name LIKE %:statusName%";

    static final String querySearchByName =
            "SELECT *FROM status WHERE name = :statusName";

    @Query(value = queryFindStatusByName, nativeQuery = true)
    public List<Status> findStatusByName(@Param("statusName") String statusName);

    @Query(value = querySearchByName, nativeQuery = true)
    public Status SearchByName(@Param("statusName") String statusName);
}
