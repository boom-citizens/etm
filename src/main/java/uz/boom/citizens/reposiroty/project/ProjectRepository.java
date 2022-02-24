package uz.boom.citizens.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.reposiroty.AbstractRepository;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:32
 * Project : library_boom
 */
public interface ProjectRepository extends JpaRepository<Project,Long>, AbstractRepository {
    Project findProjectById(Long id);

    List<Project> findAllByOrganization_Id(Long id);
}
