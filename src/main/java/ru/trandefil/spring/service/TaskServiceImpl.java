package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trandefil.spring.repository.TaskRepository;
import ru.trandefil.spring.model.Task;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public Task save(@NonNull final Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getById(@NonNull final String id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(@NonNull final Task task) {
        taskRepository.delete(task);
    }

    @Override
    @Transactional
    public void deletById(@NonNull final String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public void clear() {

    }

    @Override
    @Transactional
    public void saveAll(@NonNull final List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

}
