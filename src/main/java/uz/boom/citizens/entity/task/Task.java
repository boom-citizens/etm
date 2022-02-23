package uz.boom.citizens.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.entity.Auditable;
import uz.boom.citizens.entity.columns.ProjectColumn;

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
    private ProjectColumn columnId;

    @Column(nullable = false)
    private String name;

    private String description;

    private String level;

    private LocalDate deadline;

    private String priority;

    private Long parentId;

    private boolean completed;

//    @ManyToMany()
//    private List<Users> users;

}
