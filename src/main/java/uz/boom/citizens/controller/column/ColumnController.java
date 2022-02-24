package uz.boom.citizens.controller.column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.controller.AbstractController;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.columns.ColumnCreateDto;
import uz.boom.citizens.dto.columns.ColumnUpdateDto;
import uz.boom.citizens.services.column.ColumnService;

import java.io.IOException;

@Controller
@RequestMapping("/column/*")
public class ColumnController extends AbstractController<ColumnService> {

    @Autowired
    public ColumnController(ColumnService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String columnPage() {
        return "column/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute ColumnCreateDto dto) throws IOException {
        service.create(dto);
        return "redirect:/";
    }


    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("column", service.get(id));
        return "column/update";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.POST)
    public String update(@ModelAttribute ColumnUpdateDto dto) throws IOException {
        service.update(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("columns", service.getAll(new GenericCriteria()));
        return "column/list";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("column", service.get(id));
        return "column/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "detail/{id}/", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable Long id) {
        model.addAttribute("column", service.get(id));
        return "column/detail";
    }




}
