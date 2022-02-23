package uz.boom.citizens.controller.auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.controller.AbstractController;
import uz.boom.citizens.dto.auth.AuthUserCreateDto;
import uz.boom.citizens.entity.auth.AuthRole;
import uz.boom.citizens.services.auth.AuthUserService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/auth/*")
public class AuthController extends AbstractController<AuthUserService> {

    public AuthController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "auth/login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logoutPage() {
        return "auth/logout";
    }

//    @PreAuthorize("httpSession.getAttribute('role')==")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String craetePage(Model model) {
        model.addAttribute("dto", new AuthUserCreateDto());
        return "auth/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(name = "dto") AuthUserCreateDto dto, String role,
                         BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            return "auth/create";
        }

        service.create(dto);
        return "index";
    }


}
