package uz.boom.citizens.services.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.auth.AuthUserCreateDto;
import uz.boom.citizens.dto.auth.AuthUserDto;
import uz.boom.citizens.dto.auth.AuthUserUpdateDto;
import uz.boom.citizens.dto.file.ResourceDto;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.mapper.AuthUserMapper;
import uz.boom.citizens.reposiroty.auth.AuthUserRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.services.file.FileStorageService;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.auth.AuthUserValidator;

import java.io.IOException;
import java.util.List;

/**
 * @author D4uranbek вс. 15:01. 20.02.2022
 */
@Service
public class AuthUserService extends AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator>
        implements IAuthUserService {

    private final FileStorageService fileStorageService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    protected AuthUserService(AuthUserRepository repository, AuthUserMapper mapper, AuthUserValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService, PasswordEncoder passwordEncoder) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Long create(AuthUserCreateDto dto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(dto.getProfileImage());
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        AuthUser user = mapper.fromCreateDto(dto);
        user.setProfileImage("/uploads/" + resourceDto.getPath());
        return repository.save(user).getId();
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(AuthUserUpdateDto updateDto) throws IOException {
        return null;
    }

    @Override
    public List<AuthUserDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public AuthUserDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
