package com.example.demo.service;

import com.example.demo.entity.Priority;

import java.util.List;

public interface PriorityService {
    public List<Priority> getAllPriority();

    public Priority findPriority(Long id);

    public Priority createdPriority(Priority priority);

    public Priority updatedPriority(Priority priority);

    public void deletedPriority(Long id);

    /*
     * @desc Custom methods for queries
     */
    public List<Priority> findPriorityByName(String priorityName);
}
