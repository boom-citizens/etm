package uz.boom.citizens.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.entity.columns.ProjectColumn;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TaskDto extends GenericDto {
    private Long projectId;
    private ProjectColumn columnId;
    private String name;
    private String description;
    private String level;
    private LocalDate deadline;
    private String priority;
    private Long parentId;
    private boolean completed;
    private List<AuthUser> users;

    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, Long projectId, ProjectColumn columnId, String name, String description, String level, LocalDate deadline, String priority, Long parentId, boolean completed, List<AuthUser> users) {
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
