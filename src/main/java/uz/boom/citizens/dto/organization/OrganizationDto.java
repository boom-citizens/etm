package uz.boom.citizens.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.auth.AuthUser;

@Getter
@Setter
public class OrganizationDto extends GenericDto {

    private String name;
    private String logo;
    private String email;
    private String code;
    private String location;
    private Long owner;


    @Builder(builderMethodName = "childBuilder")
    public OrganizationDto(Long id, String name, String logo, String email, String code, String location, Long owner) {
        super(id);
        this.name = name;
        this.logo = logo;
        this.email = email;
        this.code = code;
        this.location = location;
        this.owner = owner;
    }
}

