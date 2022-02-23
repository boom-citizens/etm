package uz.boom.citizens.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.auth.AuthRole;

@Getter
@Setter
public class AuthUserDto extends GenericDto {

    private String username;
    private String password;
    private String profileImage;
    private String email;
    private boolean superUser;
    private AuthRole role;
    private boolean active;
    private boolean blocked;

    @Builder(builderMethodName = "childBuilder")
    public AuthUserDto(Long id, String username, String password, String profileImage, String email, boolean superUser, AuthRole role, boolean active, boolean blocked) {
        super(id);
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
        this.email = email;
        this.superUser = superUser;
        this.role = role;
        this.active = active;
        this.blocked = blocked;
    }
}

