package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.Priority;
import com.moisesarrona.minitask.entity.Status;
import com.moisesarrona.minitask.repository.PriorityRepository;
import com.moisesarrona.minitask.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@Service
public class TaskCatalogServiceImpl implements TaskCatalogService {
    @Autowired
    private PriorityRepository priorityRepository;

    @Autowired
    private StatusRepository statusRepository;


    @Override
    public Priority findPriorityById(Long id) {
        return priorityRepository.findPriorityById(id);
    }

    @Override
    public List<Priority> findPriorityByName(String name) {
        return priorityRepository.findPriorityByName(name);
    }

    @Override
    public Priority createdPriority(Priority priority) {
        List<Priority> priorityDB = findPriorityByName(priority.getName());
        if (priorityDB.isEmpty())
            return priorityRepository.save(priority);
        return priorityDB.get(0);
    }

    @Override
    public Status findStatusById(Long id) {
        return statusRepository.findStatusById(id);
    }

    @Override
    public List<Status> findStatusByName(String name) {
        return statusRepository.findStatusByName(name);
    }

    @Override
    public Status createdStatus(Status status) {
        List<Status> statusDB = findStatusByName(status.getName());
        if (statusDB.isEmpty())
            return statusRepository.save(status);
        return statusDB.get(0);
    }
}
