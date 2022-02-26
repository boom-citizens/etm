package uz.boom.citizens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.configs.security.SessionUser;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.services.organization.OrganizationService;
import uz.boom.citizens.services.project.ProjectServiceImpl;
import uz.boom.citizens.services.task.TaskServiceImpl;

@Controller
public class HomeController {

    private final OrganizationService organizationService;
    private final ProjectServiceImpl projectService;
    private final TaskServiceImpl taskService;

    public HomeController(OrganizationService organizationService, ProjectServiceImpl projectService, TaskServiceImpl taskService) {
        this.organizationService = organizationService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = {"index"}, method = RequestMethod.GET)
    public String indexPage(Model model) {
        model.addAttribute("session", SessionUser.session());
        model.addAttribute("projects", projectService.getAll(new GenericCriteria()));
        model.addAttribute("tasks", taskService.getAll(new GenericCriteria()));
        return "task_managemen/shablon";
    }
}
