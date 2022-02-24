package uz.boom.citizens.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yaml.snakeyaml.comments.CommentType;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.task.Task;

@Getter
@Setter


public class UpdateCommentDto extends GenericDto {
    private Task taskId;
    /*private CommentType commentType;*/
    private String commentText;
}
