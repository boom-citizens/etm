package uz.boom.citizens.dto.comment;

import lombok.*;
import org.yaml.snakeyaml.comments.CommentType;
import uz.boom.citizens.dto.Dto;
import uz.boom.citizens.entity.task.Task;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateCommentDto implements Dto {
    private Task taskId;
    /*private CommentType commentType;*/
    private String commentText;
}
