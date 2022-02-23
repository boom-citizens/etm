package uz.boom.citizens.entity.auth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author D4uranbek пн. 18:19. 21.02.2022
 */

@Getter
@Setter
@Entity
public class AuthPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;


}
