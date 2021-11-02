package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

}
