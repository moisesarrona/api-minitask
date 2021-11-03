package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Priority;

public interface PriorityService {
	public List<Priority> getAllPriority();
	
	public Priority getPriority(Long id);
	
	public Priority createPriority(Priority priority);
	
	public Priority updatePriority(Priority priority);
	
	public void deletePriority(Long id);
}
