package uz.boom.citizens.services.column;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.columns.ColumnCreateDto;
import uz.boom.citizens.dto.columns.ColumnDto;
import uz.boom.citizens.dto.columns.ColumnUpdateDto;
import uz.boom.citizens.dto.file.ResourceDto;
import uz.boom.citizens.entity.columns.ProjectColumn;
import uz.boom.citizens.mapper.column.ColumnMapper;
import uz.boom.citizens.reposiroty.colmun.ColumnRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.services.file.FileStorageService;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.column.ColumnValidator;

import java.io.IOException;
import java.util.List;

@Service
public class ColumnServiceImpl extends AbstractService<
        ColumnRepository,
        ColumnMapper,
        ColumnValidator>
        implements ColumnService {

    private final FileStorageService fileStorageService;

    protected ColumnServiceImpl(ColumnRepository repository,
                                ColumnMapper mapper,
                                ColumnValidator validator,
                                BaseUtils baseUtils,
                                FileStorageService fileStorageService) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
    }


    @Override
    public Long create(ColumnCreateDto createDto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(createDto.getIcon());
        ProjectColumn column = mapper.fromCreateDto(createDto);
        column.setIcon("/uploads/"+resourceDto.getPath());
        repository.save(column);
        return column.getId();
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(ColumnUpdateDto updateDto) throws IOException {
        return null;
    }

    @Override
    public List<ColumnDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public ColumnDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
