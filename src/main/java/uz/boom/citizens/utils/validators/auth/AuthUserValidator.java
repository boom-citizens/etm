package uz.boom.citizens.utils.validators.auth;

import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.auth.AuthUserCreateDto;
import uz.boom.citizens.dto.auth.AuthUserUpdateDto;
import uz.boom.citizens.exceptions.ValidationException;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.organization.AbstractValidator;

@Component
public class AuthUserValidator extends AbstractValidator<AuthUserCreateDto, AuthUserUpdateDto, Long> {

    protected AuthUserValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(AuthUserCreateDto authUserCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(AuthUserUpdateDto cd) throws ValidationException {

    }
}
