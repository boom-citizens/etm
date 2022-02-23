package uz.boom.citizens.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.organization.Organization;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:14
 * Project : library_boom
 */
@Getter
@Setter
@NoArgsConstructor
public class ProjectUpdateDto extends GenericDto {

    private String name;
    private String tzPath;
    private Organization organization;
    private Boolean closed;

    @Builder(builderMethodName = "childBuilder")
    public ProjectUpdateDto(Long id, String name, String tzPath, Organization organization, Boolean closed) {
        super(id);
        this.name = name;
        this.tzPath = tzPath;
        this.organization = organization;
        this.closed = closed;
    }
}
