package com.example.demo.service;

import com.example.demo.entity.Priority;
import com.example.demo.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
@Service
public class PriorityServiceImpl implements PriorityService {
    @Autowired
    private PriorityRepository priorityRepository;

    @Override
    public List<Priority> getAllPriority() {
        return priorityRepository.findAll();
    }

    @Override
    public Priority findPriority(Long id) {
        return priorityRepository.findById(id).orElse(null);
    }

    @Override
    public Priority createdPriority(Priority priority) {
        Priority priorityDB = priorityRepository.searchPriorityByName(priority.getName());
        if (priorityDB == null)
            return priorityRepository.save(priority);
        return priorityDB;
    }

    @Override
    public Priority updatedPriority(Priority priority) {
        Priority priorityDB = findPriority(priority.id);
        if (priorityDB == null)
            return null;
        if (!priority.getName().equals(priorityDB.getName()))
            priorityDB.setName(priority.getName());
        priorityDB.setDescription(priority.getDescription());
        return priorityRepository.save(priorityDB);
    }

    @Override
    public void deletedPriority(Long id) {
        priorityRepository.deleteById(id);
    }

    /*
     * @desc Custom methods for queries
     */
    @Override
    public List<Priority> findPriorityByName(String priorityName) {
        return priorityRepository.findPriorityByName(priorityName);
    }

}
