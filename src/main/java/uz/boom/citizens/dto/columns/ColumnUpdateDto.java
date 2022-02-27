package uz.boom.citizens.dto.columns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.project.Project;

@Getter
@Setter


public class ColumnUpdateDto extends GenericDto {
    private String name;
    private MultipartFile icon;
    private Boolean actice;

    public ColumnUpdateDto(Long id, String name,  MultipartFile icon,Boolean actice) {
        super(id);
        this.name = name;
        this.icon = icon;
        this.actice=actice;
    }


}
