package uz.boom.citizens.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.task.Task;

public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
}
