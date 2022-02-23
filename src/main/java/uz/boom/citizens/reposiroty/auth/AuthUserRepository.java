package uz.boom.citizens.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.reposiroty.AbstractRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {

    AuthUser findAuthUserByUsername(String username);

}
