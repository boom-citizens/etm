package uz.boom.citizens.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.configs.security.SessionUser;
import uz.boom.citizens.configs.security.UserDetails;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.entity.auth.AuthUser;
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


    @RequestMapping(value = {"wgindexfefwe"}, method = RequestMethod.GET)
    public String indexPage(Model model) {
        model.addAttribute("session_user", SessionUser.session());
        model.addAttribute("projects", projectService.getAll(new GenericCriteria()));
        model.addAttribute("tasks", taskService.getAll(new GenericCriteria()));
        return "task_managemen/shablon";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("session_user",SessionUser.session());
        model.addAttribute("projects", projectService.getAll(new GenericCriteria()));
        UserDetails user = SessionUser.session();
        if (user.isSuperUser()) return "panel/superAdmin";
        if (user.getRole().getCode().equals("ADMIN")) return "panel/admin";
        if (user.getRole().getCode().equals("MANAGER")) return "panel/manager";
        return "task_managemen/shablon";
    }
}
