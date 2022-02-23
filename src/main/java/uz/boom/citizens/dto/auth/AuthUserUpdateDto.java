package uz.boom.citizens.dto.auth;


import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.auth.AuthRole;
import uz.boom.citizens.entity.auth.Language;
import uz.boom.citizens.entity.organization.Organization;

@Getter
@Setter
public class AuthUserUpdateDto extends GenericDto {

    private String username;
    private String password;
    private String profileImage;
    private String email;
    private boolean superUser;
    private Language language;
    private Organization organization;
    private AuthRole role;
    private boolean active;
    private boolean blocked;

    public AuthUserUpdateDto(Long id, String username, String password, String profileImage, String email, boolean superUser, Language language, Organization organization, AuthRole role, boolean active, boolean blocked) {
        super(id);
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
        this.email = email;
        this.superUser = superUser;
        this.language = language;
        this.organization = organization;
        this.role = role;
        this.active = active;
        this.blocked = blocked;
    }
}
