package uz.boom.citizens.dto.auth;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.citizens.dto.Dto;
import uz.boom.citizens.entity.auth.AuthRole;

@Getter
@Setter
@Builder
public class AuthUserCreateDto implements Dto {

    private String username;
    private String password;
    private String email;
    private MultipartFile profileImage;
    private boolean superUser;
    private AuthRole role;

    public AuthUserCreateDto(String username, String password, String email, MultipartFile profileImage, boolean superUser, AuthRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileImage = profileImage;
        this.superUser = superUser;
        this.role = role;
    }

    public AuthUserCreateDto() {

    }
}
