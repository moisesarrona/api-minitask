package com.example.demo.service;

import com.example.demo.entity.Status;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
public interface StatusService {
    public List<Status> getAllStatus();

    public Status findStatus(Long id);

    public Status createdStatus(Status status);

    public Status updatedStatus(Status status);

    public void deletedStatus(Long id);

    /*
     * @desc Custom methods for queries
     */
    public List<Status> findStatusByName(String statusName);
}
