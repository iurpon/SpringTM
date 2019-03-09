package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trandefil.spring.api.TaskRepository;
import ru.trandefil.spring.api.TaskService;
import ru.trandefil.spring.model.Task;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task save(@NonNull final Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getById(@NonNull final String id) {
        return taskRepository.getById(id);
    }

    @Override
    public void delete(@NonNull final Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void deletById(@NonNull final String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public void clear() {
        taskRepository.clear();
    }

    @Override
    public void saveAll(@NonNull final List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

}
