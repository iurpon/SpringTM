package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trandefil.spring.api.ProjectRepository;
import ru.trandefil.spring.api.ProjectService;
import ru.trandefil.spring.model.Project;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project save(@NonNull final Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getById(@NonNull final String id) {
        return projectRepository.getById(id);
    }

    @Override
    public void delete(@NonNull final Project project) {
        projectRepository.delete(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public void deleteById(@NonNull final String id) {
        projectRepository.deleteById(id);
    }

}
