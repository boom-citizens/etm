package uz.boom.citizens.controller.column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.controller.AbstractController;
import uz.boom.citizens.dto.columns.ColumnCreateDto;
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
    public String columnPage()
    {
        return "column/create";
    }


    @RequestMapping(value = "create",method = RequestMethod.POST)
    public String test(@ModelAttribute ColumnCreateDto dto) throws IOException {
        service.create(dto);
        return "redirect:/";
    }


}
