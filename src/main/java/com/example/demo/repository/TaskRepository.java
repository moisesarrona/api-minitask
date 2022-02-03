package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    static final String queryFindAllTaskByMode =
            "SELECT *FROM tasks WHERE user_id = :user AND mode = true";

    static final String queryFindTaskByStatus =
            "SELECT *FROM tasks WHERE status_id = :status AND mode = true";

    static final String queryFindTaskByPriority =
            "SELECT *FROM tasks WHERE priority_id = :priority AND mode = true";

    static final String queryFindTaskByName =
            "SELECT *FROM tasks WHERE name LIKE %:name% AND mode = true";


    @Query(name = queryFindAllTaskByMode, nativeQuery = true)
    public List<Task> findAllTaskByMode(@Param("user") Long user);

    @Query(name = queryFindTaskByStatus, nativeQuery = true)
    public List<Task> findTaskByStatus(@Param("status") Long status);

    @Query(name = queryFindTaskByPriority, nativeQuery = true)
    public List<Task> findTaskByPriority(@Param("priority") Long priority);

    @Query(name = queryFindTaskByName, nativeQuery = true)
    public List<Task> findTaskByName(@Param("name") String name);
}
