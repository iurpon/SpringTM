package ru.trandefil.spring.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.api.ProjectService;
import ru.trandefil.spring.api.TaskService;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.Task;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

@Controller
public class TaskCreateController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/addTask")
    public String goToTaskForm(@RequestParam("id") String id, Model model) {
        logger.info("================================== task create GET");
        final Task task = taskService.getById(id);
        model.addAttribute("action", "create");
        model.addAttribute("task", task);
        return "editTask";
    }

/*    @PostMapping("/addTask")
    public void saveTask(
            @RequestParam("id") String projectId,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("start") Date start,
            @RequestParam("end") Date end,
            HttpServletResponse response
    ) throws IOException {
        logger.info("=========================task create POST");
        final Project project = projectService.getById(projectId);
        final Task task = new Task(null,name,description,start,end,project);
        taskService.save(task);
        response.sendRedirect("task-list");
    }*/
}
