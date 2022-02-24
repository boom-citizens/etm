package uz.boom.citizens.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.entity.Auditable;
import uz.boom.citizens.entity.columns.ProjectColumn;
import uz.boom.citizens.entity.project.Project;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "etm")
public class Task extends Auditable {


    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project projectId;

    @ManyToOne
    @JoinColumn(name = "column_id", referencedColumnName = "id")
    private ProjectColumn columnId;

    @Column(nullable = false)
    private String name;

    private String description;

    private String level;

    private Date deadline;

    private String priority;

    private Long parentId;

    private boolean completed;

}
