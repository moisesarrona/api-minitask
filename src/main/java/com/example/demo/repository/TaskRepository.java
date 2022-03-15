package com.example.demo.repository;

import com.example.demo.entity.Task;
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
public interface TaskRepository extends JpaRepository<Task, Long> {
    static final String queryFindAllTaskByUserId =
            "SELECT *FROM tasks WHERE user_id = :user_id AND mode = 1";

    static final String queryFindTaskByStatusId =
            "SELECT *FROM tasks WHERE status_id = :status_id";

    static final String queryFindTaskByPriorityId =
            "SELECT *FROM tasks WHERE priority_id = :priority_id";

    static final String queryFindAllTaskByName =
            "SELECT *FROM tasks WHERE name LIKE %:taskName%";


    @Query(name = queryFindAllTaskByUserId, nativeQuery = true)
    public List<Task> findAllTaskActiveByUserId(@Param("user_id") Long user_id);

    @Query(name = queryFindTaskByStatusId, nativeQuery = true)
    public List<Task> findTaskByStatusId(@Param("status_id") Long status_id);

    @Query(name = queryFindTaskByPriorityId, nativeQuery = true)
    public List<Task> findTaskByPriorityId(@Param("priority_id") Long priority_id);

    @Query(name = queryFindAllTaskByName, nativeQuery = true)
    public List<Task> findAllTaskByName(@Param("taskName") String taskName);
}
