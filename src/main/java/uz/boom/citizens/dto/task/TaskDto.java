package uz.boom.citizens.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDto extends GenericDto {
    private Long projectId;
    private Long columnId;
    private String name;
    private String description;
    private String level;
    private LocalDate addedTime;
    private LocalDate deadline;
    private String priority;
    private Long parentId;
    private boolean completed;

    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, Long projectId, Long columnId, String name, String description, String level, LocalDate addedTime, LocalDate deadline, String priority, Long parentId, boolean completed) {
        super(id);
        this.projectId = projectId;
        this.columnId = columnId;
        this.name = name;
        this.description = description;
        this.level = level;
        this.addedTime = addedTime;
        this.deadline = deadline;
        this.priority = priority;
        this.parentId = parentId;
        this.completed = completed;
    }
}
