package uz.boom.citizens.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.organization.OrganizationCreateDto;
import uz.boom.citizens.dto.organization.OrganizationDto;
import uz.boom.citizens.dto.organization.OrganizationUpdateDto;
import uz.boom.citizens.entity.organization.Organization;

@Component
@Mapper(componentModel = "spring")
public interface OrganizationMapper extends BaseMapper<
        Organization,
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto> {

    @Override
    @Mapping(target = "logo", ignore = true)
    Organization fromCreateDto(OrganizationCreateDto organizationCreateDto);

    @Override
    @Mapping(target = "logo", ignore = true)
    Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto);

    @Mapping(target = "logo", ignore = true)
    Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto, @MappingTarget Organization organization);
}
