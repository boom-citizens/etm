package uz.boom.citizens.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.entity.project.Project;
/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 23.02.2022 23:47
 * Project : etm
 */
@Getter
@Setter
public class ProjectMemberDto extends GenericDto {
    private Project project;

    private AuthUser authUser;

    private Boolean isLead;

    @Builder(builderMethodName = "childBuilder")
    public ProjectMemberDto(Long id, Project project, AuthUser authUser, Boolean isLead) {
        super(id);
        this.project = project;
        this.authUser = authUser;
        this.isLead = isLead;
    }
}
