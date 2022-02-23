package uz.boom.citizens.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.project.ProjectCreateDto;
import uz.boom.citizens.dto.project.ProjectDto;
import uz.boom.citizens.dto.project.ProjectUpdateDto;
import uz.boom.citizens.entity.project.Project;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:28
 * Project : library_boom
 */
@Component
@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto
        > {
    @Override
    Project fromCreateDto(ProjectCreateDto projectCreateDto);

    @Override
    Project fromUpdateDto(ProjectUpdateDto projectUpdateDto);
}
