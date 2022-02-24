package uz.boom.citizens.services.auth;

import org.springframework.stereotype.Service;
import uz.boom.citizens.entity.auth.Language;
import uz.boom.citizens.reposiroty.auth.LanguageRepository;

import java.util.List;

/**
 * @author D4uranbek чт. 18:13. 24.02.2022
 */

@Service
public class LanguageService {

    private final LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    public List<Language> getAll() {
        return repository.findAll();
    }
}
