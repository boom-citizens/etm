package uz.boom.citizens.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.task.Task;
import uz.boom.citizens.reposiroty.AbstractRepository;

public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
//
//    @Query(value = "call add_members(task_id =:taskId)", nativeQuery = true)
//    void addMembers(Param Long taskId, String members);
}