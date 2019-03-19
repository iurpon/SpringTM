package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trandefil.spring.api.ProjectRepository;
import ru.trandefil.spring.api.ProjectService;
import ru.trandefil.spring.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectRepository projectRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Project save(@NonNull final Project project) {
        logger.info("============================= project save");
        return projectRepository.save(project,entityManager);
    }

    @Override
    public Project getById(@NonNull final String id) {
        logger.info("============================= project getById");
        return projectRepository.getById(id,entityManager);
    }

    @Override
    @Transactional
    public void delete(@NonNull final Project project) {
        logger.info("============================= project delete");
        projectRepository.delete(project,entityManager);
    }

    @Override
    public List<Project> getAll() {
        logger.info("============================= project getAll");
        return projectRepository.getAll(entityManager);
    }

    @Override
    @Transactional
    public void deleteById(@NonNull final String id) {
        logger.info("============================= project deleteById");
        projectRepository.deleteById(id,entityManager);
    }

}
