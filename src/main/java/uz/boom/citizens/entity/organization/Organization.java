package uz.boom.citizens.entity.organization;

import lombok.Getter;
import lombok.Setter;
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

    private String location;

    @OneToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private AuthUser owner;
}
