package uz.boom.citizens.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.controller.AbstractController;
import uz.boom.citizens.dto.auth.AuthUserCreateDto;
import uz.boom.citizens.services.auth.AuthUserService;
import uz.boom.citizens.services.auth.LanguageService;
import uz.boom.citizens.services.auth.PermissionService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/auth/*")
public class AuthController extends AbstractController<AuthUserService> {

    private final PermissionService permissionService;
    private final LanguageService languageService;

    public AuthController(AuthUserService service, PermissionService permissionService, LanguageService languageService) {
        super(service);
        this.permissionService = permissionService;
        this.languageService = languageService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "auth/login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logoutPage() {
        return "auth/logout";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String craetePage(Model model) {
        AuthUserCreateDto dto = new AuthUserCreateDto();
        model.addAttribute("dto", dto);
        model.addAttribute("permissions", permissionService.getAll());
        model.addAttribute("languages", languageService.getAll());
        return "auth/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(name = "dto") AuthUserCreateDto dto,
                         BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            return "auth/create";
        }

        service.create(dto);
        return "index";
    }
}
