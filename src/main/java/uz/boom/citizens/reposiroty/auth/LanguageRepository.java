package uz.boom.citizens.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.auth.Language;

/**
 * @author D4uranbek чт. 18:11. 24.02.2022
 */
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
