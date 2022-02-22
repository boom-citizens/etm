package uz.boom.citizens.services.organization;

import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.organization.OrganizationCreateDto;
import uz.boom.citizens.dto.organization.OrganizationDto;
import uz.boom.citizens.dto.organization.OrganizationUpdateDto;
import uz.boom.citizens.entity.organization.Organization;
import uz.boom.citizens.services.GenericCrudService;

public interface OrganizationService extends GenericCrudService<
        Organization,
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        GenericCriteria,
        Long> {



}
