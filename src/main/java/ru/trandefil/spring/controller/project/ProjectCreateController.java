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
public class ProjectCreateController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectService projectService;

    @GetMapping("/addProject")
    public String goToProjectForm(Model model) {
        logger.info("============================== project create GET");
        model.addAttribute("action", "create");
        return "editProject";
    }

    @PostMapping("/addProject")
    public void saveProject(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            HttpServletResponse response
    ) throws IOException {
        logger.info("============================project create POST");
/*        final Project project = new Project(null,name,description);
        projectService.save(project);*/
        response.sendRedirect("projects");
    }

}
