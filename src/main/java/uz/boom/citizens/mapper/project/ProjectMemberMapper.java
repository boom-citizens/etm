package uz.boom.citizens.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.project.ProjectCreateDto;
import uz.boom.citizens.dto.project.ProjectDto;
import uz.boom.citizens.dto.project.ProjectMemberDto;
import uz.boom.citizens.dto.project.ProjectUpdateDto;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.entity.project.ProjectMember;
import uz.boom.citizens.mapper.BaseMapper;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 23.02.2022 23:49
 * Project : etm
 */
@Component
@Mapper(componentModel = "spring")
public interface ProjectMemberMapper extends BaseMapper<
        ProjectMember,
        ProjectMemberDto,
        ProjectCreateDto,
        ProjectUpdateDto
        > {
    @Override
    ProjectMemberDto toDto(ProjectMember projectMember);


    @Override
    List<ProjectMemberDto> toDto(List<ProjectMember> e);


    @Override
    ProjectMember fromCreateDto(ProjectCreateDto projectCreateDto);


    @Override
    ProjectMember fromUpdateDto(ProjectUpdateDto projectUpdateDto);


}

