package uz.boom.citizens.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import uz.boom.citizens.configs.security.SessionUser;
import uz.boom.citizens.controller.AbstractController;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.task.TaskCreateDto;
import uz.boom.citizens.dto.task.TaskUpdateDto;
import uz.boom.citizens.services.task.TaskService;
import uz.boom.citizens.services.task.TaskServiceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskServiceImpl> {

    @Autowired
    public TaskController(TaskServiceImpl service) {
        super(service);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @RequestMapping(value = "create/{projectId}/{id}/", method = RequestMethod.GET)
    private String addTaskPage() {
        return "task/create";
    }

    @RequestMapping(value = "create/{projectId}/{id}", method = RequestMethod.POST)
    private String add(@PathVariable Long id,@PathVariable Long projectId,@ModelAttribute TaskCreateDto createDto) throws IOException {
        service.createWithId(createDto,id);
        return "redirect:/column/internal/"+ projectId+"/";
    }

    @RequestMapping(value = "internal/{id}/", method = RequestMethod.GET)
    public String internalPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("session_user", SessionUser.session());
        model.addAttribute("task",service.get(id));
        return "task/internal_task";
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

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("tasks", service.getAll(new GenericCriteria()));
        return "task/list";
    }

}






















