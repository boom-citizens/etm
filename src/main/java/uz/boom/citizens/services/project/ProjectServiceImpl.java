package uz.boom.citizens.services.project;

import org.springframework.stereotype.Service;
import uz.boom.citizens.configs.security.SessionUser;
import uz.boom.citizens.configs.security.UserDetails;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.file.ResourceDto;
import uz.boom.citizens.dto.project.ProjectCreateDto;
import uz.boom.citizens.dto.project.ProjectDto;
import uz.boom.citizens.dto.project.ProjectUpdateDto;
import uz.boom.citizens.entity.organization.Organization;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.mapper.project.ProjectMapper;
import uz.boom.citizens.reposiroty.organization.OrganizationRepository;
import uz.boom.citizens.reposiroty.project.ProjectMemberRepository;
import uz.boom.citizens.reposiroty.project.ProjectRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.services.file.FileStorageService;
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
    private final OrganizationRepository organizationRepository;

    public ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService, ProjectMemberRepository projectMemberRepository, OrganizationRepository organizationRepository) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
        this.organizationRepository = organizationRepository;
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
    public List<ProjectDto> getAllById(GenericCriteria criteria, Long id) {
        UserDetails session = SessionUser.session();
        //Long orgId = session.getOrganization().getId();
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        UserDetails session = SessionUser.session();
        Long orgId = session.getOrganization().getId();
        Organization organization = organizationRepository.findById(orgId).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(repository.findAllByOrganization_id(organization));
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
