package uz.boom.citizens.mapper.comment;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.comment.CommentDto;
import uz.boom.citizens.dto.comment.CreateCommentDto;
import uz.boom.citizens.dto.comment.UpdateCommentDto;
import uz.boom.citizens.entity.comment.Comment;
import uz.boom.citizens.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")

public interface CommentMapper extends BaseMapper<
        Comment,
        CommentDto,
        CreateCommentDto,
        UpdateCommentDto> {

    @Override
    CommentDto toDto(Comment comment);

    @Override
    List<CommentDto> toDto(List<Comment> e);

    @Override
    Comment fromCreateDto(CreateCommentDto createCommentDto);

    @Override
    Comment fromUpdateDto(UpdateCommentDto updateCommentDto);

//    Comment fromUpdateDto(UpdateCommentDto updateCommentDto, @MappingTarget Comment comment);
}
