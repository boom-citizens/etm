package uz.boom.citizens.dto.organization;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.auth.AuthUser;

@Getter
@Setter
public class OrganizationUpdateDto extends GenericDto {
    private String name;
    private MultipartFile logo;
    private String email;
    private String code;
    private String location;
    private Long owner;

    public OrganizationUpdateDto(Long id, String name, MultipartFile logo, String email, String code, String location, Long owner) {
        super(id);
        this.name = name;
        this.logo = logo;
        this.email = email;
        this.code = code;
        this.location = location;
        this.owner = owner;
    }
}
