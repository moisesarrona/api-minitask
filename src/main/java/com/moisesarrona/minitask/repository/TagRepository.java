package com.moisesarrona.minitask.repository;

import com.moisesarrona.minitask.entity.Tag;
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
public interface TagRepository extends JpaRepository<Tag, Long> {
    static final String queryFindTagByName =
            "SELECT *FROM tags WHERE name LIKE %:tagName%";

    static final String querySearchTagByName =
            "SELECT *FROM tags WHERE name = :tagName";


    @Query(value = queryFindTagByName, nativeQuery = true)
    public List<Tag> findTagByName(@Param("tagName") String tagName);

    @Query(value = querySearchTagByName, nativeQuery = true)
    public Tag searchTagByName(@Param("tagName") String tagName);
}
