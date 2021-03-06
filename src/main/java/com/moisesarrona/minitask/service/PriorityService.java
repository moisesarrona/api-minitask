package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.Priority;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
public interface PriorityService {
    public List<Priority> getAllPriority();

    public Priority findPriority(Long id);

    public Priority createdPriority(Priority priority);

    public Priority updatedPriority(Priority priority);

    public void deletedPriority(Long id);

    public List<Priority> findPriorityByName(String priorityName);
}
