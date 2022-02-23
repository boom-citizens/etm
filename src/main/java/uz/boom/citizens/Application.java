package uz.boom.citizens;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.reposiroty.auth.AuthUserRepository;

import java.util.Arrays;

@SpringBootApplication
public class Application /*implements CommandLineRunner*/ {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;


    public Application(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Override
    public void run(String... args) throws Exception {

        authUserRepository.deleteAll();

        AuthUser user1 = new AuthUser();
        user1.setUsername("user1");
        user1.setPassword(passwordEncoder.encode("user1"));
        user1.setActive(true);
        user1.setBlocked(false);

        AuthUser user2 = new AuthUser();

        user2.setUsername("user2");
        user2.setPassword(passwordEncoder.encode("user2"));
        user2.setActive(true);
        user2.setBlocked(false);

        authUserRepository.saveAll(Arrays.asList(user1, user2));

    }
}
