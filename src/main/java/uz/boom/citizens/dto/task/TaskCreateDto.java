package uz.boom.citizens.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.Dto;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TaskCreateDto implements Dto {
    private String name;
    private String description;
    private String level;
    private LocalDate addedTime;
    private LocalDate deadline;
    private String priority;
}