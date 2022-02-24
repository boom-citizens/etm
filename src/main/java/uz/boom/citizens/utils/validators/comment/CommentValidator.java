package uz.boom.citizens.utils.validators.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.comment.CreateCommentDto;
import uz.boom.citizens.dto.comment.UpdateCommentDto;
import uz.boom.citizens.exceptions.ValidationException;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.AbstractValidator;

@Component

public class CommentValidator extends AbstractValidator<CreateCommentDto, UpdateCommentDto,Long> {

    @Autowired
    public CommentValidator(BaseUtils utils){
        super(utils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CreateCommentDto dto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(UpdateCommentDto cd) throws ValidationException {

    }
}
