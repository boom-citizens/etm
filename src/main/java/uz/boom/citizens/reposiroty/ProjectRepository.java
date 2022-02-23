package uz.boom.citizens.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.project.Project;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:32
 * Project : library_boom
 */
public interface ProjectRepository extends JpaRepository<Project,Long>,AbstractRepository {
}
