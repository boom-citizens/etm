package uz.boom.citizens.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.citizens.dto.Dto;
import uz.boom.citizens.entity.auth.AuthUser;

@Getter
@Setter
@Builder
public class OrganizationCreateDto implements Dto {
    private String name;
    private MultipartFile logo;
    private String email;
    private String code;
    private String location;
    private AuthUser owner;


    public OrganizationCreateDto(String name, MultipartFile logo, String email, String code, String location, AuthUser owner) {
        this.name = name;
        this.logo = logo;
        this.email = email;
        this.code = code;
        this.location = location;
        this.owner = owner;
    }
}
