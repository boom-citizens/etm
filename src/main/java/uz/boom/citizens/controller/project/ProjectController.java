package uz.boom.citizens.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.configs.security.SessionUser;
import uz.boom.citizens.controller.AbstractController;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.project.ProjectCreateDto;
import uz.boom.citizens.dto.project.ProjectUpdateDto;
import uz.boom.citizens.services.auth.AuthUserService;
import uz.boom.citizens.services.project.ProjectMemberServiceImpl;
import uz.boom.citizens.services.project.ProjectService;
import uz.boom.citizens.services.project.ProjectServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:13
 * Project : library_boom
 */
@Controller
@RequestMapping("/project/*")
public class ProjectController extends AbstractController<ProjectService> {

    private final ProjectMemberServiceImpl projectMemberService;
    private final AuthUserService authUserService;

    @Autowired
    public ProjectController(ProjectServiceImpl service, ProjectMemberServiceImpl projectMemberService, AuthUserService authUserService) {
        super(service);
        this.projectMemberService = projectMemberService;
        this.authUserService = authUserService;
    }

    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "project/create";
    }


    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute ProjectCreateDto dto) throws IOException {
        service.create(dto);
        return "redirect:/index";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project", service.get(id));
        return "project/update";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.POST)
    public String update(@ModelAttribute ProjectUpdateDto dto) throws IOException {
        service.update(dto);
        return "redirect:/index";
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project", service.get(id));
        return "project/delete";
    }
    @RequestMapping(value = "delete/{id}/", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/index";
    }

    @RequestMapping(value = "member_delete/{id}/", method = RequestMethod.GET)
    public String memberDeletePage(Model model,@PathVariable(name = "id") Long id) {
        model.addAttribute("member",authUserService.get(id));
        return "project/member_delete";
    }

    @RequestMapping(value = "member_delete/{id}/", method = RequestMethod.POST)
    public String memberDelete(@PathVariable(name = "id") Long id) {
        projectMemberService.delete(id);
        return "redirect:/index";
    }

    @RequestMapping(value = "members/{id}/", method = RequestMethod.GET)
    public String projectMemberPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project", service.get(id));
        model.addAttribute("members", projectMemberService.getMembers(id));
        return "project/members";
    }


    @RequestMapping(value = "detail/{id}/", method = RequestMethod.GET)
    public String detailPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project", service.get(id));
        return "project/detail";
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("projects", service.getAll(new GenericCriteria()));
        return "project/list";
    }

    @RequestMapping(value = "add_member/{id}/", method = RequestMethod.GET)
    public String addMemberPage(Model model,@PathVariable Long id) {
        model.addAttribute("org", SessionUser.session().getOrganization());
        model.addAttribute("users", authUserService.getAllById(new GenericCriteria(),id));
        return "project/add_member";
    }
    @RequestMapping(value = "add_member/{id}/", method = RequestMethod.POST)
    public String addMember(@PathVariable Long id,@ModelAttribute(name = "users") List<Long> userIdList) {
        projectMemberService.addUser(id,userIdList);
        return "redirect:/index";
    }
}
