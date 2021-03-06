package uz.boom.citizens.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.columns.ProjectColumn;
import uz.boom.citizens.entity.project.Project;

import java.util.Date;

@Getter
@Setter
public class TaskDto extends GenericDto {
    private Project projectId;
    private ProjectColumn columnId;
    private String name;
    private String description;
    private String level;
    private Date deadline;
    private String priority;
    private Long parentId;
    private boolean completed;

    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, Project projectId, ProjectColumn columnId, String name, String description, String level, Date deadline, String priority, Long parentId, boolean completed) {
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
    }
}
