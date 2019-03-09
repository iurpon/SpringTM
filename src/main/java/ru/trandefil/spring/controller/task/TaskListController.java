package ru.trandefil.spring.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.trandefil.spring.api.ProjectService;
import ru.trandefil.spring.api.TaskService;
import ru.trandefil.spring.model.Task;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class TaskListController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("tasks")
    public String taskList(Model model){
        final List<Task> taskList = taskService.getAll();
        model.addAttribute("tasks",taskList);
        return "task-list";
    }
}
