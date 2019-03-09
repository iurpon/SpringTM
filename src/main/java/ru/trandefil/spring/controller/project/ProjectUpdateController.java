package ru.trandefil.spring.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.api.ProjectService;
import ru.trandefil.spring.model.Project;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class ProjectUpdateController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectService projectService;

    @GetMapping("/updateProject")
    public String goToProjectForm(
            @RequestParam("id") String id,
            Model model
    ) {
        logger.info("=========================== project update GET");
        final Project project = projectService.getById(id);
        logger.info("============================= get Project " + project);
        model.addAttribute("action","update");
        model.addAttribute("project",project);
        return "editProject";
    }

    @PostMapping("/updateProject")
    public void updateProject(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            HttpServletResponse response
    ) throws IOException {
        logger.info("========================= project create POST");
        final Project project = new Project(id,name,description);
        projectService.save(project);
        response.sendRedirect("projects");
    }

}
