package uz.boom.citizens.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.column.Columns;
import uz.boom.citizens.entity.user.Users;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TaskDto extends GenericDto {
    private Long projectId;
    private Columns columnId;
    private String name;
    private String description;
    private String level;
    private LocalDate deadline;
    private String priority;
    private Long parentId;
    private boolean completed;
    private List<Users> users;

    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, Long projectId, Columns columnId, String name, String description, String level, LocalDate deadline, String priority, Long parentId, boolean completed, List<Users> users) {
        super(id);
        this.projectId = projectId;
        this.columnId = columnId;
        this.name = name;
        this.description = description;
        this.level = level;
        this.deadline = deadline;
        this.priority = priority;
        this.parentId = parentId;
        this.completed = completed;
        this.users = users;
    }
}
