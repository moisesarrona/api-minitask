package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.Status;

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

    public List<Status> findStatusByName(String statusName);
}
