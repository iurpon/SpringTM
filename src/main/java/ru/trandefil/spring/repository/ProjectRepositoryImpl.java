package ru.trandefil.spring.repository;

import lombok.NonNull;
import org.springframework.stereotype.Repository;
import ru.trandefil.spring.api.ProjectRepository;
import ru.trandefil.spring.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Override
    public Project save(Project project, EntityManager entityManager) {
        if (project.isNew()) {
            project.setId(UUID.randomUUID().toString());
            entityManager.persist(project);
        }
        return entityManager.merge(project);
    }

    @Override
    public Project getById(@NonNull final String id, @NonNull final EntityManager entityManager) {
        final String getById = "select p from Project p where p.id = :id";
        final Query query = entityManager.createQuery(getById);
        query.setParameter("id", id);
        final Project project = (Project) query.getSingleResult();
        return project;
    }

    @Override
    public void delete(Project project, EntityManager entityManager) {
        entityManager.remove(project);
    }

    @Override
    public List<Project> getAll(EntityManager entityManager) {
        final String getAll = "select p from Project p";
        final Query query = entityManager.createQuery(getAll);
        final List<Project> projects = query.getResultList();
        return projects;
    }

    @Override
    public void deleteById(String id, EntityManager entityManager) {
        final Project project = getById(id, entityManager);
        if (project != null) {
            entityManager.remove(project);
        }
    }

}
