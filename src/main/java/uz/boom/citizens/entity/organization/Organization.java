package uz.boom.citizens.entity.organization;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import uz.boom.citizens.entity.Auditable;
import uz.boom.citizens.entity.auth.AuthUser;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "organizations")
public class Organization extends Auditable {

    @Column(nullable = false, length = 100)
    private String name;

    private String logo;

    private String email;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(name = "is_blocked", columnDefinition = "BOOLEAN default false")
    private boolean blocked;

    private String location;

    private Long owner;
}
