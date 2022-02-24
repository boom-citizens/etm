package uz.boom.citizens.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.task.Task;
import uz.boom.citizens.reposiroty.AbstractRepository;

public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
}
