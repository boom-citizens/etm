package uz.boom.citizens.dto.organization;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.citizens.dto.GenericDto;

@Getter
@Setter
public class OrganizationUpdateDto extends GenericDto {
    private String name;
    private MultipartFile logo;
    private String code;
    private String email;

    public OrganizationUpdateDto(Long id, String name, MultipartFile logo, String code, String email) {
        super(id);
        this.name = name;
        this.logo = logo;
        this.code = code;
        this.email = email;
    }
}
