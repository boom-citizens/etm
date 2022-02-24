package uz.boom.citizens.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.organization.OrganizationUpdateDto;
import uz.boom.citizens.dto.project.ProjectCreateDto;
import uz.boom.citizens.dto.project.ProjectDto;
import uz.boom.citizens.dto.project.ProjectUpdateDto;
import uz.boom.citizens.entity.organization.Organization;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.mapper.BaseMapper;

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

    @Mapping(target ="tzPath", ignore = true)
    Project fromUpdateDto(ProjectUpdateDto projectUpdateDto, @MappingTarget Project project);

}
