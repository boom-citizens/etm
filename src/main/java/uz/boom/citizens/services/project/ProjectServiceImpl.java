package uz.boom.citizens.services.project;

import org.springframework.stereotype.Service;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.organization.OrganizationDto;
import uz.boom.citizens.dto.project.ProjectCreateDto;
import uz.boom.citizens.dto.project.ProjectDto;
import uz.boom.citizens.dto.project.ProjectUpdateDto;
import uz.boom.citizens.entity.organization.Organization;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.mapper.OrganizationMapper;
import uz.boom.citizens.mapper.ProjectMapper;
import uz.boom.citizens.reposiroty.ProjectRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.services.organization.OrganizationServiceImpl;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.project.ProjectValidator;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:34
 * Project : library_boom
 */
@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository, ProjectMapper, ProjectValidator>
        implements ProjectService {

    private final OrganizationServiceImpl organizationService;
    private final OrganizationMapper organizationMapper;

    public ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator, BaseUtils baseUtils, OrganizationServiceImpl organizationService, OrganizationMapper organizationMapper) {
        super(repository, mapper, validator, baseUtils);
        this.organizationService = organizationService;
        this.organizationMapper = organizationMapper;
    }


    @Override
    public Long create(ProjectCreateDto createDto) {
        Project project = mapper.fromCreateDto(createDto);
        OrganizationDto organizationDto = organizationService.get(1L);

        repository.save(project);
        return project.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        return null;
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
