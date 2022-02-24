package uz.boom.citizens.services.auth;

import org.springframework.stereotype.Service;
import uz.boom.citizens.entity.auth.AuthRole;
import uz.boom.citizens.reposiroty.auth.RoleRepository;

/**
 * @author D4uranbek чт. 11:37. 24.02.2022
 */

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Long create(AuthRole role) {
        return repository.save(role).getId();
    }

    public void addPermissions(Long roleId, String permissions) {
        repository.addPermissions(roleId, permissions);
    }
}
