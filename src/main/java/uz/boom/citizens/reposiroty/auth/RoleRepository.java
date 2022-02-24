package uz.boom.citizens.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.boom.citizens.entity.auth.AuthRole;

public interface RoleRepository extends JpaRepository<AuthRole, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "call add_permissions(:user_id, :role, :permissions)",
            nativeQuery = true)
    void addPermissions(@Param("user_id") Long userId,
                        @Param("role") String role,
                        @Param("permissions") String permissions);
}
