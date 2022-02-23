package uz.boom.citizens.utils.validators.task;

import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.task.TaskCreateDto;
import uz.boom.citizens.dto.task.TaskUpdateDto;
import uz.boom.citizens.exceptions.ValidationException;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.AbstractValidator;

@Component
public class TaskValidator extends AbstractValidator<TaskCreateDto, TaskUpdateDto, Long> {
    protected TaskValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(TaskCreateDto taskCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(TaskUpdateDto cd) throws ValidationException {

    }
}
