package uz.boom.citizens.services.project;

import org.springframework.stereotype.Service;
import uz.boom.citizens.dto.auth.AuthUserDto;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.entity.project.ProjectMember;
import uz.boom.citizens.mapper.auth.AuthUserMapper;
import uz.boom.citizens.mapper.project.ProjectMemberMapper;
import uz.boom.citizens.reposiroty.auth.AuthUserRepository;
import uz.boom.citizens.reposiroty.project.ProjectMemberRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.project.ProjectValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 23.02.2022 23:53
 * Project : etm
 */
@Service
public class ProjectMemberServiceImpl extends AbstractService<ProjectMemberRepository, ProjectMemberMapper, ProjectValidator>
{

    private final AuthUserRepository authUserRepository;
    private final AuthUserMapper authUserMapper;

    public ProjectMemberServiceImpl(ProjectMemberRepository repository, ProjectMemberMapper mapper, ProjectValidator validator, BaseUtils baseUtils, AuthUserRepository authUserRepository, AuthUserMapper authUserMapper) {
        super(repository, mapper, validator, baseUtils);
        this.authUserRepository = authUserRepository;
        this.authUserMapper = authUserMapper;
    }

    public List<AuthUserDto> getMembers(Long id) {
        List<ProjectMember> projectMembers = repository.findAllByProjectId(id);
        List<AuthUser> authUsers=new ArrayList<>();
        for (ProjectMember projectMember : projectMembers) {
            authUsers.add(projectMember.getAuthUser());
        }
        return authUserMapper.toDto(authUsers);
    }
}
