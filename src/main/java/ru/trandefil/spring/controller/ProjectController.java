package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.UserService;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.User;

import java.util.List;
import java.util.logging.Logger;

public class ProjectController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    private User user;

    @GetMapping("/updateProject")
    public String goToProjectForm(@RequestParam("id") String id, Model model) {
        logger.info("=========================== project update GET");
        final Project project = projectService.getById(id);
        logger.info("============================= get Project " + project);
        model.addAttribute("project", project);
        return "editProjectForm";
    }

    @GetMapping("/projects")
    public String projectList(Model model) {
        logger.info("========================== Project list GET");
        final List<Project> projectList = projectService.getAll();
        model.addAttribute("projects", projectList);
        return "project-list";
    }

    @GetMapping("/deleteProject")
    public String deleteProject(
            @RequestParam("id") String id) {
        logger.info("======================== project delete GET");
        projectService.deleteById(id);
        return "redirect:/projects";
    }

    @GetMapping("/addProject")
    public String goToProjectForm(Model model) {
        logger.info("============================== project create GET");
        final Project project = new Project();
        user = userService.getByName("root");
        project.setUser(user);
        model.addAttribute("project", project);
        return "editProjectForm";
    }

    @PostMapping("/addProject")
    public String saveProject(@ModelAttribute("project") Project project) {
        project.setUser(user);
        logger.info("============================project create POST . saving Project : " + project);
        projectService.save(project);
        return "redirect:/projects";
    }

}
