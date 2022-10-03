package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.Phase;
import com.moisesarrona.minitask.entity.Priority;
import com.moisesarrona.minitask.entity.Tag;
import com.moisesarrona.minitask.repository.PriorityRepository;
import com.moisesarrona.minitask.repository.PhaseRepository;
import com.moisesarrona.minitask.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@Service
public class TaskCatalogServiceImpl implements TaskCatalogService {
    @Autowired
    private PriorityRepository priorityRepository;

    @Autowired
    private PhaseRepository phaseRepository;

    @Autowired
    private TagRepository tagRepository;


    @Override
    public Priority findPriorityById(Long id) {
        return priorityRepository.findPriorityById(id);
    }

    @Override
    public List<Priority> findPrioritiesByName(String name) {
        return priorityRepository.findPrioritiesByName(name);
    }

    @Override
    public Priority createdPriority(Priority priority) {
        Priority priorityDB = priorityRepository.findPriorityByName(priority.getName());
        if (priorityDB == null)
            return priorityRepository.save(priority);
        return priorityDB;
    }


    @Override
    public Phase findPhaseById(Long id) {
        return phaseRepository.findPhaseById(id);
    }

    @Override
    public List<Phase> findPhasesByName(String name) {
        return phaseRepository.findPhasesByName(name);
    }

    @Override
    public Phase createdPhase(Phase phase) {
        Phase phaseDB = phaseRepository.findPhaseByName(phase.getName());
        if (phaseDB == null)
            return phaseRepository.save(phase);
        return phaseDB;
    }


    @Override
    public Tag findTagById(Long id) {
        return tagRepository.findTagById(id);
    }

    @Override
    public List<Tag> findTagsByName(String name) {
        return tagRepository.findTagsByName(name);
    }

    @Override
    public Tag createdTag(Tag tag) {
        Tag tagDB = tagRepository.findTagByName(tag.getName());
        if (tagDB == null)
            return tagRepository.save(tag);
        return tagDB;
    }
}
