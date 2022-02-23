package uz.boom.citizens.reposiroty.colmun;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.columns.ProjectColumn;
import uz.boom.citizens.reposiroty.AbstractRepository;

public interface ColumnRepository extends JpaRepository<ProjectColumn,Long>, AbstractRepository {
}
