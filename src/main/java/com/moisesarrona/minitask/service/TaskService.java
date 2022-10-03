package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.Task;

import java.util.Date;
import java.util.List;

/**
 * @author moisesarrona
 * @version 0.2
 */
public interface TaskService {
    public List<Task> findAllTasksByDate(Long userId, Date dateStart, Date dateEnd);

    public List<Task> findAllTasksByPriority(Long userId, Long priorityId);

    public List<Task> findAllTasksByPhase(Long userId, Long statusId);

    public Task createdTask(Task task);

    public Task updatedTask(Task task);

    public Task deletedTask(Long idTask);
}
