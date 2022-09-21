package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.Priority;
import com.moisesarrona.minitask.entity.Status;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
public interface TaskCatalogService {
    public Priority findPriorityById(Long id);

    public List<Priority> findPriorityByName(String name);

    public Priority createdPriority(Priority priority);


    public Status findStatusById(Long id);

    public List<Status> findStatusByName(String Name);

    public Status createdStatus(Status status);
}
