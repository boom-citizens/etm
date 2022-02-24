package uz.boom.citizens.configs.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import uz.boom.citizens.entity.auth.AuthPermission;
import uz.boom.citizens.entity.auth.AuthRole;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.entity.organization.Organization;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author D4uranbek пн. 18:13. 21.02.2022
 */
@Getter
@Setter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String profileImage;
    private boolean superUser;
    private boolean active;
    private boolean blocked;
    private AuthRole role;
    private Organization organization;

    public UserDetails(AuthUser user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.profileImage = user.getProfileImage();
        this.superUser = user.isSuperUser();
        this.active = user.isActive();
        this.blocked = user.isBlocked();
        this.role = user.getRole();
        this.organization = user.getOrganization();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();

        if (Objects.isNull(role)) {
            return authorities;
        }

        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));

        List<AuthPermission> permissions = role.getPermissions();

        if (Objects.isNull(permissions)) {
            return authorities;
        }

        authorities.addAll(permissions.stream()
                .map(permission ->
                        new SimpleGrantedAuthority(permission.getCode()))
                .collect(Collectors.toSet()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
