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
public class TaskUpdateController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/updateTask")
    public String goToTaskForm(@RequestParam("id") String id, Model model){
        logger.info("================================== task update GET");
        final Task task = taskService.getById(id);
        model.addAttribute("taskEntity",task);
        return "editTaskForm";
    }

}
