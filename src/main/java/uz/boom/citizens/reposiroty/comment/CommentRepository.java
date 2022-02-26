package uz.boom.citizens.reposiroty.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.comment.Comment;
import uz.boom.citizens.reposiroty.AbstractRepository;

import javax.persistence.Column;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, AbstractRepository {
}
