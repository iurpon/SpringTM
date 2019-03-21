package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.TaskService;
import ru.trandefil.spring.service.UserService;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.Task;
import ru.trandefil.spring.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class TaskController {

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
        final User user = userService.getByName("root");
        task.setAssignee(user);
        task.setExecutor(user);
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/deleteTask")
    public String deleteTask(@RequestParam("id") String id, HttpServletResponse response) throws IOException {
        logger.info("==================================== delete task GET");
        taskService.deletById(id);
        return "redirect:/tasks";
    }

    @GetMapping("tasks")
    public String taskList(Model model) {
        logger.info("====================================== task list GET");
        final List<Task> taskList = taskService.getAll();
        model.addAttribute("tasks", taskList);
        return "task-list";
    }

    @GetMapping("/updateTask")
    public String goToTaskUpdateForm(@RequestParam("id") String id, Model model) {
        logger.info("================================== task update GET");
        final Task task = taskService.getById(id);
        logger.info("================================== getting task : " + task);
        model.addAttribute("task", task);
        return "editTaskForm";
    }

}
