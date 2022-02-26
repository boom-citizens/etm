package uz.boom.citizens.reposiroty.colmun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.boom.citizens.entity.columns.ProjectColumn;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.reposiroty.AbstractRepository;

import java.util.List;

@Transactional
public interface ColumnRepository extends JpaRepository<ProjectColumn, Long>, AbstractRepository {

    @Query("from ProjectColumn p where p.project_id=:project")
    List<ProjectColumn> findAllByProject_id(@Param("project") Project project);
}
