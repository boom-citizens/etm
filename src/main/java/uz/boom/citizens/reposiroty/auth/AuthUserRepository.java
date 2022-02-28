package uz.boom.citizens.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.entity.organization.Organization;
import uz.boom.citizens.reposiroty.AbstractRepository;

import java.util.List;

@Transactional
@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {

    AuthUser findAuthUserByUsername(String username);

    List<AuthUser> findAllByOrganization_Id(Long id);

    @Modifying
    @Query(value = "update users set password = :new_password where id = :session_id;", nativeQuery = true)
    void changePassword(@Param("session_id") Long sessionId, @Param("new_password") String newPassword);

    @Query("from AuthUser a where a.organization=:org")
    List<AuthUser> getAllByOrg(@Param("org") Organization organization);
}
