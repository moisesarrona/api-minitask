package com.example.demo.service;

import com.example.demo.entity.Priority;
import com.example.demo.entity.Status;
import com.example.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    @Override
    public Status getStatus(Long id) {
        return statusRepository.findById(id).orElse(null);
    }

    @Override
    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status updateStatus(Status status) {
        Status statusDB = getStatus(status.getId());
        if (statusDB == null) {
            return null;
        }
        statusDB.setName(status.getName());
        statusDB.setDescription(status.getDescription());
        return statusRepository.save(statusDB);
    }

    @Override
    public void deteleStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
