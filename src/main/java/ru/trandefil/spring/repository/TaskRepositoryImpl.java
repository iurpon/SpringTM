package ru.trandefil.spring.repository;

import org.springframework.stereotype.Repository;
import ru.trandefil.spring.api.TaskRepository;
import ru.trandefil.spring.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;
import java.util.logging.Logger;

@Repository
public class TaskRepositoryImpl implements TaskRepository{

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public Task save(Task task, EntityManager em) {
        if(task.isNew() || task.getId().isEmpty()){
            task.setId(UUID.randomUUID().toString());
            em.persist(task);
            return task;
        }
        return em.merge(task);
    }

    @Override
    public Task getById(String id, EntityManager em) {
        final TypedQuery<Task> typedQuery = em.createQuery("select t from Task t where t.id = :id",Task.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void delete(Task task, EntityManager em) {
        if(em.contains(task)){
            em.remove(task);
            return;
        }
        Task ref = em.getReference(Task.class,task.getId());
        em.remove(ref);
    }

    @Override
    public void deleteById(String id, EntityManager em) {
        Task ref = em.getReference(Task.class,id);
        em.remove(ref);
    }

    @Override
    public List<Task> getAll( EntityManager em) {
        TypedQuery<Task> typedQuery = em.createQuery("select t from Task t",Task.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Task> getAll(String userId, EntityManager em) {
        String query = "select t from Task t where t.assignee.id = :id or t.executor.id = :id";
        TypedQuery<Task> typedQuery = em.createQuery(query,Task.class);
        typedQuery.setParameter("id",userId);
        return typedQuery.getResultList();
    }

    @Override
    public void clear() {

    }

    @Override
    public void saveAll(List<Task> tasks, EntityManager em) {

    }
}
