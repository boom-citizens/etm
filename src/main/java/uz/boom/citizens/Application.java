package uz.boom.citizens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"uz.boom.citizens.*"})
public class Application /*implements CommandLineRunner */{
/*private final AuthRepository repository;
private final PasswordEncoder encoder;*/



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


  /*  @Override
    public void run(String... args) throws Exception {

    }*/
}
