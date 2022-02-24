package uz.boom.citizens.dto.auth;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.citizens.dto.Dto;
import uz.boom.citizens.entity.auth.AuthRole;
import uz.boom.citizens.entity.auth.Language;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserCreateDto implements Dto {

    private String username;
    private String password;
    private String email;
    private MultipartFile profileImage;
    private boolean superUser;
    private List<Long> permissions;
    private String role;
}
