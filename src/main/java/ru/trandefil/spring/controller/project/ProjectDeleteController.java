package ru.trandefil.spring.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.api.ProjectService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class ProjectDeleteController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectService projectService;

    @GetMapping("/deleteProject")
    public void deleteProject(
            @RequestParam("id") String id,
            HttpServletResponse response
    ) throws IOException {
        logger.info("======================== project delete GET");
        projectService.deleteById(id);
        response.sendRedirect("projects");
    }

}
