package ru.trandefil.spring.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.trandefil.spring.api.ProjectService;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.User;

import java.util.logging.Logger;

@Controller
public class ProjectCreateController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    private User user;

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
