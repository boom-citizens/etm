package uz.boom.citizens.services.column;

import org.mapstruct.Mapper;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.columns.ColumnCreateDto;
import uz.boom.citizens.dto.columns.ColumnDto;
import uz.boom.citizens.dto.columns.ColumnUpdateDto;

import uz.boom.citizens.entity.columns.ProjectColumn;
import uz.boom.citizens.services.GenericCrudService;


public interface    ColumnService extends GenericCrudService<
        ProjectColumn,
        ColumnDto,
        ColumnCreateDto,
        ColumnUpdateDto,
        GenericCriteria,
        Long> {
}
