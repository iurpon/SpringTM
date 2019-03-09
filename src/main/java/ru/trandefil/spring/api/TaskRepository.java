package ru.trandefil.spring.api;

import ru.trandefil.spring.model.Task;

import java.util.List;

public interface TaskRepository {

    Task save(Task project);

    Task getById(String id);

    void delete(Task project);

    void deleteById(String id);

    List<Task> getAll();

    void clear();

    void saveAll(List<Task> tasks);

}
