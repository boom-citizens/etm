package uz.boom.citizens.entity.auth;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import uz.boom.citizens.entity.Auditable;
import uz.boom.citizens.entity.organization.Organization;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class AuthUser extends Auditable {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "is_super_user", nullable = false)
    @ColumnDefault(value = "false")
    private boolean superUser;

    @Column(name = "is_active", nullable = false)
    @ColumnDefault(value = "true")
    private boolean active;

    @Column(name = "is_blocked", nullable = false)
    @ColumnDefault(value = "false")
    private boolean blocked;

    @ManyToOne
    @JoinColumn(name = "language", referencedColumnName = "id")
    private Language language;

    @OneToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    private AuthRole role;

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private Organization organization;

}
