package uz.boom.citizens.utils.validators.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.organization.OrganizationCreateDto;
import uz.boom.citizens.dto.organization.OrganizationUpdateDto;
import uz.boom.citizens.exceptions.ValidationException;
import uz.boom.citizens.utils.BaseUtils;

@Component
public class OrganizationValidator extends AbstractValidator<OrganizationCreateDto, OrganizationUpdateDto, Long> {


    @Autowired
    protected OrganizationValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(OrganizationCreateDto organizationCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(OrganizationUpdateDto cd) throws ValidationException {

    }
}
