package uz.boom.citizens.configs.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author D4uranbek ср. 10:12. 23.02.2022
 */
@Component
public class SessionUser {

    public static UserDetails session() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Long sessionId() {
        return session().getId();
    }

}
