package com.moisesarrona.minitask.repository;

import com.moisesarrona.minitask.entity.Phase;
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
public interface PhaseRepository extends JpaRepository<Phase, Long> {
    static final String queryFindPhaseById =
            "SELECT *FROM phases WHERE id = :id";

    static final String queryFindPhaseByName =
            "SELECT *FROM phases WHERE name = :name";

    static final String queryFindPhasesByName =
            "SELECT *FROM phases WHERE name LIKE %:name%";


    @Query(value = queryFindPhaseById, nativeQuery = true)
    public Phase findPhaseById(@Param("id") Long id);

    @Query(value = queryFindPhaseByName, nativeQuery = true)
    public Phase findPhaseByName(@Param("name") String name);

    @Query(value = queryFindPhasesByName, nativeQuery = true)
    public List<Phase> findPhasesByName(@Param("name") String name);
}
