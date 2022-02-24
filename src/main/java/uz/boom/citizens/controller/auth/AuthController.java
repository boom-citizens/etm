package uz.boom.citizens.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.citizens.controller.AbstractController;
import uz.boom.citizens.dto.auth.AuthUserCreateDto;
import uz.boom.citizens.entity.auth.AuthPermission;
import uz.boom.citizens.services.auth.AuthUserService;
import uz.boom.citizens.services.auth.PermissionService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/auth/*")
public class AuthController extends AbstractController<AuthUserService> {

    private final PermissionService permissionService;

    public AuthController(AuthUserService service, PermissionService permissionService) {
        super(service);
        this.permissionService = permissionService;
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
        model.addAttribute("permissions", permissionService.getAll());
        return "auth/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(name = "dto") AuthUserCreateDto dto,
                         @ModelAttribute(name = "permissions") List<AuthPermission> permissions,
                         BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            return "auth/create";
        }

        dto.getRole().setPermissions(permissions);
        service.create(dto);
        return "index";
    }


}
