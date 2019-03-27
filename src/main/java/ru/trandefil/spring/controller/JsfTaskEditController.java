package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.Task;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.TaskService;
import ru.trandefil.spring.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@ViewScoped
@ManagedBean
public class JsfTaskEditController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private String id;

    private Task task = new Task();

    private String projectId;

    public void init() {
        logger.info("=============== jsfProjectEditController init");
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
        if (id == null) {
            return;
        }
        Task byId = taskService.getById(id);
        if (byId != null) {
            task = byId;
        }
    }

    public Iterable<Project> getProjects(){
        return projectService.getAll();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setProjectId(String projectId){
        logger.info("=================== setProject ID");
        final Project project = projectService.getById(projectId);
        task.setProject(project);
    }

    public String getProjectId(){
        logger.info("================ get Project ID");
        if(task.getProject() == null) return null;
        return task.getProject().getId();
    }


    public String save(){
        logger.info("========================= task save()");
//        taskService.save(task);
        return "task-list.xhtml";
    }

}
