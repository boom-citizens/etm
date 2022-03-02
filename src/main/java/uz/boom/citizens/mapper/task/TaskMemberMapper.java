package uz.boom.citizens.mapper.task;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.task.TaskCreateDto;
import uz.boom.citizens.dto.task.TaskMemberDto;
import uz.boom.citizens.dto.task.TaskUpdateDto;
import uz.boom.citizens.entity.task.TaskMember;
import uz.boom.citizens.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TaskMemberMapper extends BaseMapper<TaskMember, TaskMemberDto, TaskCreateDto, TaskUpdateDto> {
    @Override
    TaskMemberDto toDto(TaskMember taskMember);

    @Override
    List<TaskMemberDto> toDto(List<TaskMember> e);

    @Override
    TaskMember fromCreateDto(TaskCreateDto createDto);

    @Override
    TaskMember fromUpdateDto(TaskUpdateDto taskUpdateDto);
}
