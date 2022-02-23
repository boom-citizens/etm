package uz.boom.citizens.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.task.TaskCreateDto;
import uz.boom.citizens.dto.task.TaskDto;
import uz.boom.citizens.dto.task.TaskUpdateDto;
import uz.boom.citizens.entity.task.Task;
import uz.boom.citizens.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<Task, TaskDto, TaskCreateDto, TaskUpdateDto> {
    @Override
    TaskDto toDto(Task task);

    @Override
    List<TaskDto> toDto(List<Task> e);

    @Override
    Task fromCreateDto(TaskCreateDto taskCreateDto);

    @Override
    Task fromUpdateDto(TaskUpdateDto taskUpdateDto);

    Task fromUpdateDto(TaskUpdateDto taskUpdateDto, @MappingTarget Task task);
}
