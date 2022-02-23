package uz.boom.citizens.dto.auth;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.citizens.dto.Dto;
import uz.boom.citizens.entity.auth.AuthRole;
import uz.boom.citizens.entity.auth.Language;
import uz.boom.citizens.entity.organization.Organization;

@Getter
@Setter
@Builder
public class AuthUserCreateDto implements Dto {

    private String username;
    private String password;
    private String email;
    private MultipartFile profileImage;
    private boolean superUser;
    private Language language;
    private Organization organization;
    private AuthRole role;

    public AuthUserCreateDto(String username, String password, String email, MultipartFile profileImage, boolean superUser, Language language, Organization organization, AuthRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileImage = profileImage;
        this.superUser = superUser;
        this.language = language;
        this.organization = organization;
        this.role = role;
    }

    public AuthUserCreateDto() {

    }
}
