package com.moisesarrona.minitask.repository;

import com.moisesarrona.minitask.entity.Phase;
import com.moisesarrona.minitask.entity.Tag;
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
public interface TagRepository extends JpaRepository<Tag, Long> {
    static final String queryFindTagById =
            "SELECT *FROM tags WHERE id = :id";

    static final String queryFindTagByName =
            "SELECT *FROM tags WHERE name = :name";

    static final String queryFindTagsByName =
            "SELECT *FROM tags WHERE name LIKE %:name%";


    @Query(value = queryFindTagById, nativeQuery = true)
    public Tag findTagById(@Param("id") Long id);

    @Query(value = queryFindTagByName, nativeQuery = true)
    public Tag findTagByName(@Param("name") String name);

    @Query(value = queryFindTagsByName, nativeQuery = true)
    public List<Tag> findTagsByName(@Param("name") String name);
}
