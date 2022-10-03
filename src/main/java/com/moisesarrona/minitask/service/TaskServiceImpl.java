package com.moisesarrona.minitask.service;

import com.moisesarrona.minitask.entity.Task;
import com.moisesarrona.minitask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author moisesarrona
 * @version 0.2
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAllTasksByDate(Long userId, Date dateStart, Date dateEnd) {
        return taskRepository.findAllTasksByDate(userId, dateStart, dateEnd);
    }

    @Override
    public List<Task> findAllTasksByPriority(Long userId, Long priorityId) {
        return taskRepository.findAllTasksByPriority(userId, priorityId);
    }

    @Override
    public List<Task> findAllTasksByPhase(Long userId, Long statusId) {
        return taskRepository.findAllTasksByPhase(userId, statusId);
    }

    @Override
    public Task createdTask(Task task) {
        Task taskDB = taskRepository.findAllTaskByName(task.getUser().getId(), task.getName());
        if (taskDB != null)
            return taskDB;
        task.setCompleted(false);
        task.setStatus(true);
        return taskRepository.save(task);
    }

    @Override
    public Task updatedTask(Task task) {
        Task taskDB = taskRepository.findTaskById(task.getId());
        if (taskDB == null)
            return null;
        taskDB.setName(task.getName());
        taskDB.setDescription(task.getDescription());
        taskDB.setObservation(task.getObservation());
        taskDB.setDateStart(task.getDateStart());
        taskDB.setDateEnd(task.getDateEnd());
        taskDB.setRepetitive(task.getRepetitive());
        taskDB.setCompleted(task.getCompleted());
        taskDB.setPriority(task.getPriority());
        taskDB.setPhase(task.getPhase());
        taskDB.setTags(task.getTags());
        taskRepository.save(taskDB);
        return taskDB;
    }

    @Override
    public Task deletedTask(Long idTask) {
        Task taskDB = taskRepository.findTaskById(idTask);
        if (taskDB == null)
            return null;
        taskDB.setStatus(!taskDB.getStatus());
        return taskRepository.save(taskDB);
    }
}
