package uz.boom.citizens.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.entity.project.ProjectMember;
import uz.boom.citizens.reposiroty.AbstractRepository;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 23.02.2022 23:26
 * Project : etm
 */
@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember,Long>, AbstractRepository {

    List<ProjectMember> findAllByProjectId(Long id);

}
