package com.moisesarrona.minitask.repository;

import com.moisesarrona.minitask.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    static final String queryFindTaskById =
            "SELECT *FROM tasks WHERE id = :idTask";

    static final String queryFindAllTaskByName =
            "SELECT *FROM tasks WHERE user_id = :userId AND name = :name";

    static final String queryFindAllTasksByDate =
            "SELECT *FROM tasks WHERE user_id = :userId AND date_Start = :dateStart AND date_End = :dateEnd";

    static final String queryFindAllTasksByPriority =
            "SELECT *FROM tasks WHERE user_id = :userId AND priority_id = :priorityId";

    static final String queryFindAllTasksByPhase =
            "SELECT *FROM tasks WHERE user_id = :userId AND phase_id = :phaseId";

    static final String queryFindAllTasksByNameAndDescription =
            "SELECT *FROM tasks WHERE user_id = :userId AND CONCAT_WS(' ', name, description) LIKE %:name%";


    @Query(value = queryFindTaskById, nativeQuery = true)
    public Task findTaskById(@Param("idTask") Long idTask);

    @Query(value = queryFindAllTaskByName, nativeQuery = true)
    public Task findAllTaskByName(@Param("userId") Long userId, @Param("name") String name);

    @Query(value = queryFindAllTasksByDate, nativeQuery = true)
    public List<Task> findAllTasksByDate(@Param("userId") Long userId, @Param("dateStart") Date dateStart,
                                        @Param("dateEnd") Date dateEnd);

    @Query(value = queryFindAllTasksByPriority, nativeQuery = true)
    public List<Task> findAllTasksByPriority(@Param("userId") Long userId, @Param("priorityId") Long priorityId);

    @Query(value = queryFindAllTasksByPhase, nativeQuery = true)
    public List<Task> findAllTasksByPhase(@Param("userId") Long userId, @Param("phaseId") Long phaseId);

    @Query(value = queryFindAllTasksByNameAndDescription, nativeQuery = true)
    public List<Task> findAllTasksByNameAndDescription(@Param("userId") Long userId, @Param("name") String name);
}
