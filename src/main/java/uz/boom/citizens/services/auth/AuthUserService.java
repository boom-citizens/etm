package uz.boom.citizens.services.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.auth.AuthUserCreateDto;
import uz.boom.citizens.dto.auth.AuthUserDto;
import uz.boom.citizens.dto.auth.AuthUserUpdateDto;
import uz.boom.citizens.dto.file.ResourceDto;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.mapper.auth.AuthUserMapper;
import uz.boom.citizens.reposiroty.auth.AuthUserRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.services.file.FileStorageService;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.auth.AuthUserValidator;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author D4uranbek вс. 15:01. 20.02.2022
 */
@Service
public class AuthUserService extends AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator>
        implements IAuthUserService {

    private final FileStorageService fileStorageService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    protected final ObjectMapper objectMapper;


    @Autowired
    protected AuthUserService(AuthUserRepository repository, AuthUserMapper mapper, AuthUserValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService, PasswordEncoder passwordEncoder, RoleService roleService, ObjectMapper objectMapper) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.objectMapper = objectMapper;
    }

    @Override
    public Long create(AuthUserCreateDto dto) throws IOException {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        AuthUser user = mapper.fromCreateDto(dto);

        if (Objects.nonNull(dto.getProfileImage())) {
            ResourceDto resourceDto = fileStorageService.store(dto.getProfileImage());
            user.setProfileImage("/uploads/" + resourceDto.getPath());
        }

        Long userId = repository.save(user).getId();

        String permissions = objectMapper.writeValueAsString(dto.getPermissions());
        roleService.addPermissions(userId, dto.getRole(), permissions, dto.getLanguage());

        return userId;
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
    public List<AuthUserDto> getAllById(GenericCriteria criteria, Long id) {
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

    public void changePassword(Long sessionId, String newPassword) {
        repository.changePassword(sessionId, newPassword);
    }
}
