package uz.boom.citizens.services.task;

import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.task.TaskCreateDto;
import uz.boom.citizens.dto.task.TaskDto;
import uz.boom.citizens.dto.task.TaskUpdateDto;
import uz.boom.citizens.entity.task.Task;
import uz.boom.citizens.services.GenericCrudService;

public interface TaskService extends GenericCrudService<Task, TaskDto, TaskCreateDto, TaskUpdateDto, GenericCriteria, Long> {
}
