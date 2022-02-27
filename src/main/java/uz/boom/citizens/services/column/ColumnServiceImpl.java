package uz.boom.citizens.services.column;

import org.springframework.stereotype.Service;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.columns.ColumnCreateDto;
import uz.boom.citizens.dto.columns.ColumnDto;
import uz.boom.citizens.dto.columns.ColumnUpdateDto;
import uz.boom.citizens.dto.file.ResourceDto;
import uz.boom.citizens.entity.columns.ProjectColumn;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.mapper.column.ColumnMapper;
import uz.boom.citizens.reposiroty.colmun.ColumnRepository;
import uz.boom.citizens.reposiroty.project.ProjectRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.services.file.FileStorageService;
import uz.boom.citizens.services.project.ProjectServiceImpl;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.column.ColumnValidator;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ColumnServiceImpl extends AbstractService<
        ColumnRepository,
        ColumnMapper,
        ColumnValidator>
        implements ColumnService {

    private final FileStorageService fileStorageService;
    private final ProjectRepository projectRepository;

    protected ColumnServiceImpl(ColumnRepository repository,
                                ColumnMapper mapper,
                                ColumnValidator validator,
                                BaseUtils baseUtils,
                                FileStorageService fileStorageService, ProjectServiceImpl projectService, ProjectRepository projectRepository) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
        this.projectRepository = projectRepository;
    }


    @Override
    public Long create(ColumnCreateDto createDto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(createDto.getIcon());
        ProjectColumn column = mapper.fromCreateDto(createDto);
        column.setIcon("/uploads/"+resourceDto.getPath());
        repository.save(column);
        return column.getId();
    }

    public Long createWithId(ColumnCreateDto createDto,Long projectId) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(createDto.getIcon());
        ProjectColumn column = mapper.fromCreateDto(createDto);
        column.setIcon("/uploads/"+resourceDto.getPath());
        column.setProject_id(projectRepository.getById(projectId));
        repository.save(column);
        return column.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(ColumnUpdateDto updateDto) throws IOException {
        ProjectColumn column = repository.findById(updateDto.getId()).orElseThrow(() -> {
            throw new RuntimeException("not found");
        });
        if (!updateDto.getName().equals("")) {
            column.setName(updateDto.getName());
        }

        if ( updateDto.getIcon().getSize() !=0 ) {
            ResourceDto resourceDto = fileStorageService.store(updateDto.getIcon());
            column.setIcon("/uploads/" + resourceDto.getPath());
        }
        if(updateDto.getActice()!=column.getActive()){
            column.setActive(updateDto.getActice());
        }

//        column.setPosition(updateDto.getPosition());
//        column.setActive(updateDto.getActive());
//        column.setProject_id(updateDto.getProject_id());

        repository.save(column);
        return null;
    }

    @Override
    public List<ColumnDto> getAllById(GenericCriteria criteria, Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("not found");
        });
        return mapper.toDto(repository.findAllByProject_id(project));
    }

    @Override
    public List<ColumnDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public ColumnDto get(Long id) {
        ProjectColumn column = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("not found");
        });
        return mapper.toDto(column);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }





}
