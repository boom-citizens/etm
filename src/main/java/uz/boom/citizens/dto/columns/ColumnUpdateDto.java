package uz.boom.citizens.dto.columns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.project.Project;

@Getter
@Setter


public class ColumnUpdateDto extends GenericDto {
    private String name;
    private Project project_id;
    private int position;
    private String  icon;
    private Boolean active;

    public ColumnUpdateDto(Long id, String name, Project project_id, int position, String icon, Boolean active) {
        super(id);
        this.name = name;
        this.project_id = project_id;
        this.position = position;
        this.icon = icon;
        this.active = active;
    }


}
