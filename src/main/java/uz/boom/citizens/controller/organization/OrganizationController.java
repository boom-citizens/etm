package uz.boom.citizens.controller.organization;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.controller.AbstractController;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.organization.OrganizationCreateDto;
import uz.boom.citizens.dto.organization.OrganizationUpdateDto;
import uz.boom.citizens.services.organization.OrganizationService;
import uz.boom.citizens.services.organization.OrganizationServiceImpl;

import java.io.IOException;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController extends AbstractController<OrganizationServiceImpl> {

    @Autowired
    public OrganizationController(OrganizationServiceImpl service)   {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "organization/create";
    }

    @SneakyThrows
    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/organization/list/";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/update";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.POST)
    public String update(@ModelAttribute OrganizationUpdateDto dto) throws IOException {
        service.update(dto);
        return "redirect:/organization/list/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/delete";
    }
    @RequestMapping(value = "block/{id}", method = RequestMethod.GET)
    public String blockPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/block";
    }
    @RequestMapping(value = "unblock/{id}", method = RequestMethod.GET)
    public String unblockPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/unblock";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/organization/list/";
    }

    @RequestMapping(value = "block/{id}", method = RequestMethod.POST)
    public String block(@PathVariable(name = "id") Long id) {
        service.block(id);
        return "redirect:/organization/list/";
    }

    @RequestMapping(value = "unblock/{id}", method = RequestMethod.POST)
    public String unblock(@PathVariable(name = "id") Long id) {
        service.unblock(id);
        return "redirect:/organization/list/";
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detailPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/detail";
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        return "organization/list";
    }
}