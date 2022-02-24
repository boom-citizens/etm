package uz.boom.citizens.services.comment;

import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.comment.CommentDto;
import uz.boom.citizens.dto.comment.CreateCommentDto;
import uz.boom.citizens.dto.comment.UpdateCommentDto;
import uz.boom.citizens.entity.comment.Comment;
import uz.boom.citizens.services.GenericCrudService;

public interface CommentService extends GenericCrudService<
        Comment,
        CommentDto,
        CreateCommentDto,
        UpdateCommentDto,
        GenericCriteria,
        Long> {
}
