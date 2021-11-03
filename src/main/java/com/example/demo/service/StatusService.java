package com.example.demo.service;

import com.example.demo.entity.Status;

import java.util.List;

public interface StatusService {
    public List<Status> getAllStatus();

    public Status getStatus(Long id);

    public Status createStatus(Status status);

    public Status updateStatus(Status status);

    public void deleteStatus(Long id);
}
