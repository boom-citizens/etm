package uz.boom.citizens.dto.comment;

import lombok.*;
import org.yaml.snakeyaml.comments.CommentType;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.entity.task.Task;

@Getter
@Setter


public class CommentDto extends GenericDto {
    private Task taskId;
    /*private CommentType commentType;*/
    private String commentText;


    @Builder(builderMethodName = "childBuilder")
    public CommentDto(Long id, Task taskId, String commentText) {
        super(id);
        this.taskId = taskId;
        this.commentText = commentText;
    }


}
