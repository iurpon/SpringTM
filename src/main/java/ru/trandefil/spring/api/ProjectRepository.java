package ru.trandefil.spring.api;

import ru.trandefil.spring.model.Project;

import javax.persistence.EntityManager;
import java.util.List;

public interface ProjectRepository {

    Project save(Project project, EntityManager entityManager);

    Project getById(String id, EntityManager entityManager);

    void delete(Project project, EntityManager entityManager);

    void deleteById(String id, EntityManager entityManager);

    List<Project> getAll(EntityManager entityManager);

}
