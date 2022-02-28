package uz.boom.citizens.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.entity.project.ProjectMember;
import uz.boom.citizens.reposiroty.AbstractRepository;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 23.02.2022 23:26
 * Project : etm
 */
@Transactional
@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long>, AbstractRepository {

    @Query(value = "select * from citizens.etm.project_member p where p.project_id=:projectId",nativeQuery = true)
    List<ProjectMember> findAllByProject(@Param("projectId") Long projectId);

    @Query(value = "select p.user_id from citizens.etm.project_member p where p.project_id=:projectId",nativeQuery = true)
    List<Long> findUserIdByProject(@Param("projectId") Long projectId);

    @Query(value = "select p.project_id from citizens.etm.project_member p where p.user_id=:userId",nativeQuery = true)
    List<Long> findProjectIdByUser(@Param("userId") Long userId);

    @Modifying
    @Query("delete from ProjectMember p where p.authUser=:auth")
    void deleteByAuthUser(@Param("auth") AuthUser authUser);

    @Modifying
    @Query(value = "insert into citizens.etm.project_member(user_id,project_id) values (:userId,:projectId)",nativeQuery = true)
    void insertMember(@Param("projectId") Long projectId,@Param("userId") Long userid);

}
