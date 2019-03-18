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
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.Task;
import ru.trandefil.spring.model.User;

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

    @Autowired
    private UserService userService;

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
        task.setProject(project);
        final User user = userService.getById("b3247ebd-8f86-4f9b-9d18-08686125f51b");
        task.setAssignee(user);
        task.setExecutor(user);
        taskService.save(task);
         return "redirect:/tasks";
    }
}
