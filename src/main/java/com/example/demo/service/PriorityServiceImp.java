package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Priority;
import com.example.demo.repository.PriorityRepository;

@Service
public class PriorityServiceImp implements PriorityService {
	@Autowired
	private PriorityRepository priorityRepository;

	@Override
	public List<Priority> getAllPriority() {
		return priorityRepository.findAll();
	}

	@Override
	public Priority getPriority(Long id) {
		return priorityRepository.findById(id).orElse(null);
	}

	@Override
	public Priority createPriority(Priority priority) {
		return priorityRepository.save(priority);
	}

	@Override
	public Priority updatePriority(Priority priority) {
		Priority priorityDB = getPriority(priority.getId());
		if (priorityDB == null) {
			return null;
		}
		priorityDB.setName(priority.getName());
		priorityDB.setDescription(priority.getDescription());
		return priorityRepository.save(priorityDB);
	}

	@Override
	public void detelePriority(Long id) {
		priorityRepository.deleteById(id);;
		
	}

}
