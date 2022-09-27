package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.Phase;
import com.moisesarrona.minitask.entity.Priority;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
public interface TaskCatalogService {
    public Priority findPriorityById(Long id);

    public List<Priority> findPrioritiesByName(String name);

    public Priority createdPriority(Priority priority);


    public Phase findPhaseById(Long id);

    public List<Phase> findPhasesByName(String Name);

    public Phase createdPhase(Phase phase);
}
