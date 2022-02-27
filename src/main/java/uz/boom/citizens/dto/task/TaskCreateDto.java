package uz.boom.citizens.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.Dto;
import uz.boom.citizens.entity.columns.ProjectColumn;
import uz.boom.citizens.entity.project.Project;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TaskCreateDto implements Dto {
    private Project projectId;
    private ProjectColumn columnId;
    private String name;
    private String description;
    private String level;
    private String priority;
    private Date deadline;
}