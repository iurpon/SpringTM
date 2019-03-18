package ru.trandefil.spring.api;

import ru.trandefil.spring.model.Task;

import javax.persistence.EntityManager;
import java.util.List;

public interface TaskRepository {

    Task save(Task project, EntityManager em);

    Task getById(String id, EntityManager em);

    void delete(Task project, EntityManager em);

    void deleteById(String id, EntityManager em);

    List<Task> getAll(EntityManager em);

    List<Task> getAll(String userId, EntityManager em);

    void clear();

    void saveAll(List<Task> tasks, EntityManager em);

}
