package uz.boom.citizens.mapper.column;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.columns.ColumnCreateDto;
import uz.boom.citizens.dto.columns.ColumnDto;
import uz.boom.citizens.dto.columns.ColumnUpdateDto;
import uz.boom.citizens.entity.columns.ProjectColumn;
import uz.boom.citizens.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ColumnMapper extends BaseMapper<
        ProjectColumn,
        ColumnDto,
        ColumnCreateDto,
        ColumnUpdateDto> {

    @Override
    @Mapping(target = "icon", ignore = true)
    ColumnDto toDto(ProjectColumn projectColumn);

    @Override
    @Mapping(target = "icon", ignore = true)
    List<ColumnDto> toDto(List<ProjectColumn> e);

    @Override
    @Mapping(target = "icon", ignore = true)
    ProjectColumn fromCreateDto(ColumnCreateDto columnCreateDto);

    @Override
    @Mapping(target = "icon", ignore = true)
    ProjectColumn fromUpdateDto(ColumnUpdateDto columnUpdateDto);
}
