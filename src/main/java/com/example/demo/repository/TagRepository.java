package com.example.demo.repository;

import com.example.demo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    static String findByName = "SELECT *FROM tags WHERE name = :tagName";

    @Query(value = findByName, nativeQuery = true)
    public Tag findByName(String tagName);
}
