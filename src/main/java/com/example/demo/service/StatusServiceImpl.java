package com.example.demo.service;

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
    public Status findStatus(Long id) {
        return statusRepository.findById(id).orElse(null);
    }

    @Override
    public Status createdStatus(Status status) {
        Status statusDB = statusRepository.findByName(status.getName());
        if (statusDB == null) {
            return statusRepository.save(status);
        }
        return statusDB;
    }

    @Override
    public Status updatedStatus(Status status) {
        Status statusDB = findStatus(status.getId());
        if (statusDB == null) {
            return null;
        }
        statusDB.setName(status.getName());
        statusDB.setDescription(status.getDescription());
        return statusRepository.save(statusDB);
    }

    @Override
    public void deletedStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
