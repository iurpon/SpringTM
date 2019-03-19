package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trandefil.spring.api.TaskRepository;
import ru.trandefil.spring.api.TaskService;
import ru.trandefil.spring.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Task save(@NonNull final Task task) {
        return taskRepository.save(task,entityManager);
    }

    @Override
    public Task getById(@NonNull final String id) {
        return taskRepository.getById(id,entityManager);
    }

    @Override
    public void delete(@NonNull final Task task) {
        taskRepository.delete(task,entityManager);
    }

    @Override
    public void deletById(@NonNull final String id) {
        taskRepository.deleteById(id,entityManager);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll(entityManager);
    }

    @Override
    public void clear() {
        taskRepository.clear();
    }

    @Override
    public void saveAll(@NonNull final List<Task> tasks) {
        taskRepository.saveAll(tasks,entityManager);
    }

}
