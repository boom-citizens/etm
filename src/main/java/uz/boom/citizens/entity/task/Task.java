package uz.boom.citizens.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.entity.Auditable;
import uz.boom.citizens.entity.column.Columns;
import uz.boom.citizens.entity.user.Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Task extends Auditable {


    private Long projectId;

    @ManyToOne
    private Columns columnId;

    @Column(nullable = false)
    private String name;

    private String description;

    private String level;

    private LocalDate deadline;

    private String priority;

    private Long parentId;

    private boolean completed;

    @ManyToMany()
    private List<Users> users;

}
