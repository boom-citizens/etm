package uz.boom.citizens.utils.validators.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.project.ProjectCreateDto;
import uz.boom.citizens.dto.project.ProjectUpdateDto;
import uz.boom.citizens.exceptions.ValidationException;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.AbstractValidator;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:37
 * Project : library_boom
 */
@Component
public class ProjectValidator extends AbstractValidator<ProjectCreateDto, ProjectUpdateDto,Long> {

    @Autowired
    public ProjectValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProjectCreateDto projectCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ProjectUpdateDto cd) throws ValidationException {

    }
}
