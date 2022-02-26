package uz.boom.citizens.services.comment;

import org.springframework.stereotype.Service;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.comment.CommentDto;
import uz.boom.citizens.dto.comment.CreateCommentDto;
import uz.boom.citizens.dto.comment.UpdateCommentDto;
import uz.boom.citizens.entity.comment.Comment;
import uz.boom.citizens.mapper.comment.CommentMapper;
import uz.boom.citizens.reposiroty.comment.CommentRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.comment.CommentValidator;

import java.io.IOException;
import java.util.List;

@Service

public class CommentServiceImpl extends AbstractService<
        CommentRepository,
        CommentMapper,
        CommentValidator> implements CommentService{

    protected CommentServiceImpl(CommentRepository repository,
                                 CommentMapper mapper,
                                 CommentValidator validator,
                                 BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }

    @Override
    public Long create(CreateCommentDto createDto) throws IOException {
        Comment comment = mapper.fromCreateDto(createDto);
        repository.save(comment);
        return comment.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(UpdateCommentDto updateDto) throws IOException {
        Comment comment = repository.findById(updateDto.getId()).orElseThrow(() -> {
           throw  new RuntimeException("Not found");
        });
       /* if (Objects.nonNull(updateDto.getCommentType()))
            comment.setCommentType(updateDto.getCommentType());*/

        if (!updateDto.getCommentText().equals(""))
            comment.setCommentText(updateDto.getCommentText());

        return null;
    }

    @Override
    public List<CommentDto> getAllById(GenericCriteria criteria, Long id) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<CommentDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public CommentDto get(Long id) {
        Comment comment = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
        return mapper.toDto(comment);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
