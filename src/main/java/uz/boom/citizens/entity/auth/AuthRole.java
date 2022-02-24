package uz.boom.citizens.entity.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author D4uranbek пн. 18:15. 21.02.2022
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AuthRole {

    public AuthRole(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "auth_user_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<AuthPermission> permissions = new ArrayList<>();


}
