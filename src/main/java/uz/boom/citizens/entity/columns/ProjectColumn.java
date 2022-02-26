package uz.boom.citizens.entity.columns;

import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.entity.Auditable;
import uz.boom.citizens.entity.project.Project;

import javax.persistence.*;

@Entity
@Getter
@Setter

@Table(name = "column" , schema = "etm")
public class ProjectColumn extends Auditable {

    @Column(name = "name",nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project_id;

    @Column(name = "position")
    private int position;

    @Column(name = "icon")
    private String  icon;

    @Column(name = "active")
    private Boolean active;
}
