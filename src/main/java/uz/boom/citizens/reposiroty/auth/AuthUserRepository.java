package uz.boom.citizens.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.reposiroty.AbstractRepository;

import java.util.List;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {

    AuthUser findAuthUserByUsername(String username);

    List<AuthUser> findAllByOrganization_Id(Long id);

}
