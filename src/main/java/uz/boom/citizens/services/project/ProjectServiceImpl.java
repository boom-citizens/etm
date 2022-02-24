package uz.boom.citizens.services.project;

import org.springframework.stereotype.Service;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.auth.AuthUserDto;
import uz.boom.citizens.dto.file.ResourceDto;
import uz.boom.citizens.dto.project.ProjectCreateDto;
import uz.boom.citizens.dto.project.ProjectDto;
import uz.boom.citizens.dto.project.ProjectUpdateDto;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.entity.project.ProjectMember;
import uz.boom.citizens.mapper.project.ProjectMapper;
import uz.boom.citizens.mapper.organization.OrganizationMapper;
import uz.boom.citizens.reposiroty.project.ProjectMemberRepository;
import uz.boom.citizens.reposiroty.project.ProjectRepository;
import uz.boom.citizens.reposiroty.auth.AuthUserRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.services.file.FileStorageService;
import uz.boom.citizens.services.organization.OrganizationServiceImpl;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.project.ProjectValidator;

import java.io.IOException;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:34
 * Project : library_boom
 */
@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository, ProjectMapper, ProjectValidator>
        implements ProjectService {

    private final FileStorageService fileStorageService;

    public ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator, BaseUtils baseUtils, OrganizationServiceImpl organizationService, OrganizationMapper organizationMapper, FileStorageService fileStorageService, AuthUserRepository authUserRepository, ProjectMemberRepository projectMemberRepository) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
    }


    @Override
    public Long create(ProjectCreateDto createDto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(createDto.getTz());
        Project project = mapper.fromCreateDto(createDto);
        project.setClosed(false);
        project.setTzPath("/uploads/" + resourceDto.getPath());
        repository.save(project);
        return project.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto dto) throws IOException {
        Project project = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        if (!dto.getName().equals(""))
            project.setName(dto.getName());

        if (dto.getTzFile().getSize()!=0) {
            ResourceDto resourceDto = fileStorageService.store(dto.getTzFile());
            project.setTzPath("/uploads/" + resourceDto.getPath());
        }
        project.setClosed(dto.getClosed());
        repository.save(project);
        return null;
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ProjectDto get(Long id) {
        Project project = repository.findById((id)).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(project);
    }


    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

}
