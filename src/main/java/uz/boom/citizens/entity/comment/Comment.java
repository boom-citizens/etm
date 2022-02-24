package uz.boom.citizens.entity.comment;

import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.entity.Auditable;
import uz.boom.citizens.entity.task.Task;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comments")

public class Comment extends Auditable {

    @ManyToOne
//    @Column(name = "task_id",nullable = false)
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private  Task taskId;

   /* @OneToOne
    @Column(name = "comment_type",nullable = false)
    private CommentType commentType;*/

    @Column
    private String commentText;

}
