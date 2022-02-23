package uz.boom.citizens.services.auth;

import org.springframework.stereotype.Service;
import uz.boom.citizens.entity.auth.AuthPermission;
import uz.boom.citizens.reposiroty.auth.PermissionRepository;

import java.util.List;

/**
 * @author D4uranbek чт. 0:11. 24.02.2022
 */
@Service
public class PermissionService {

    private final PermissionRepository repository;

    public PermissionService(PermissionRepository repository) {
        this.repository = repository;
    }

    public List<AuthPermission> getAll() {
        return repository.findAll();
    }
}
