package uz.boom.citizens.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.citizens.entity.task.TaskMember;
import uz.boom.citizens.reposiroty.AbstractRepository;

import java.util.List;

@Repository
public interface TaskMemberRepository extends JpaRepository<TaskMember, Long>, AbstractRepository {
    List<TaskMember> findAllByTaskId(Long id);

}
