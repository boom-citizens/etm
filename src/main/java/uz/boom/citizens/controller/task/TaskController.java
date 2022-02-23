package uz.boom.citizens.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.controller.AbstractController;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.organization.OrganizationUpdateDto;
import uz.boom.citizens.dto.task.TaskCreateDto;
import uz.boom.citizens.dto.task.TaskUpdateDto;
import uz.boom.citizens.services.task.TaskService;

import java.io.IOException;

@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskService> {
    public TaskController(TaskService service) {
        super(service);
    }

    @RequestMapping(value = "add/", method = RequestMethod.GET)
    private String addTaskPage() {
        return "task/add";
    }

    @RequestMapping(value = "add/", method = RequestMethod.POST)
    private String add(@ModelAttribute TaskCreateDto createDto) throws IOException {
        service.create(createDto);
        return "redirect:";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/update";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.POST)
    public String update(@ModelAttribute TaskUpdateDto dto) throws IOException {
        service.update(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detailPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/details";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("task", service.getAll(new GenericCriteria()));
        return "task/list";
    }

}






















