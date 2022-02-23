package uz.boom.citizens.utils.validators.column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.columns.ColumnCreateDto;
import uz.boom.citizens.dto.columns.ColumnUpdateDto;
import uz.boom.citizens.exceptions.ValidationException;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.AbstractValidator;

@Component
public class ColumnValidator    extends AbstractValidator<
        ColumnCreateDto,
        ColumnUpdateDto,
        Long> {

    @Autowired
    protected ColumnValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ColumnCreateDto columnCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ColumnUpdateDto cd) throws ValidationException {

    }
}
