package ru.trandefil.spring.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.trandefil.spring.api.ProjectService;
import ru.trandefil.spring.model.Project;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ProjectListController {

    @Autowired
    private ProjectService projectService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/projects")
    public String projectList(Model model) {
        logger.info("========================== Project list GET");
        final List<Project> projectList = projectService.getAll();
        model.addAttribute("projects", projectList);
        return "project-list";
    }

}
