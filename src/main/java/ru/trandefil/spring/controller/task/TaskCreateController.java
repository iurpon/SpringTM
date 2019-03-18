package ru.trandefil.spring.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    private Project project;

    @GetMapping("/addTask")
    public String goToTaskForm(@RequestParam("id") String id, Model model) {
        logger.info("================================== task create GET");
        project = projectService.getById(id);
        final Task task = new Task();
        task.setProject(project);
        model.addAttribute("task", task);
        return "editTaskForm";
    }

    @PostMapping("/addTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        logger.info("=========================task create POST. task created : " + task);
//        taskService.save(task);
         return "redirect:/tasks";
    }
}
