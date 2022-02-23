package uz.boom.citizens.services.auth;


import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.auth.AuthUserCreateDto;
import uz.boom.citizens.dto.auth.AuthUserDto;
import uz.boom.citizens.dto.auth.AuthUserUpdateDto;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.services.GenericCrudService;

/**
 * @author D4uranbek вс. 15:02. 20.02.2022
 */
public interface IAuthUserService extends GenericCrudService<
        AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto,
        GenericCriteria,
        Long> {
}
