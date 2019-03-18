package ru.trandefil.spring.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.api.ProjectService;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.Project;

import java.util.logging.Logger;

@Controller
public class ProjectUpdateController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @GetMapping("/updateProject")
    public String goToProjectForm(@RequestParam("id") String id, Model model) {
        logger.info("=========================== project update GET");
        final Project project = projectService.getById(id);
        logger.info("============================= get Project " + project);
        model.addAttribute("project", project);
        return "editProjectForm";
    }

}
