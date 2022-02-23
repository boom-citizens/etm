package uz.boom.citizens.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.auth.AuthUserCreateDto;
import uz.boom.citizens.dto.auth.AuthUserDto;
import uz.boom.citizens.dto.auth.AuthUserUpdateDto;
import uz.boom.citizens.entity.auth.AuthUser;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<
        AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto> {

    @Override
    @Mapping(target = "profileImage", ignore = true)
    AuthUser fromCreateDto(AuthUserCreateDto dto);

    @Override
    @Mapping(target = "profileImage", ignore = true)
    AuthUser fromUpdateDto(AuthUserUpdateDto dto);

    @Override
    @Mapping(target = "profileImage", ignore = true)
    AuthUserDto toDto(AuthUser authUser);

    @Override
    @Mapping(target = "profileImage", ignore = true)
    List<AuthUserDto> toDto(List<AuthUser> e);

    @Mapping(target = "profileImage", ignore = true)
    AuthUser fromUpdateDto(AuthUserUpdateDto dto, @MappingTarget AuthUser authUser);
}
