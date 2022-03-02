package uz.boom.citizens.dto.task;

import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.entity.task.Task;

@Getter
@Setter
public class TaskMemberDto extends GenericDto {
    private Task task;
    private AuthUser authUser;

    public TaskMemberDto(Long id, Task task, AuthUser authUser) {
        super(id);
        this.task = task;
        this.authUser = authUser;
    }
}
