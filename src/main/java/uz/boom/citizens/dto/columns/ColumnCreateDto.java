package uz.boom.citizens.dto.columns;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.citizens.dto.Dto;
import uz.boom.citizens.entity.project.Project;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class  ColumnCreateDto implements Dto {

    private String name;
    private Project project_id;
    private int position;
    private MultipartFile icon;
}
