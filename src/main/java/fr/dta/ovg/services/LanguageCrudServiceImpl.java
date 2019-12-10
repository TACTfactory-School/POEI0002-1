package fr.dta.ovg.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.ovg.entities.Language;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.LanguageRepository;
import fr.dta.ovg.services.user.UserDeleteService;

@Service
public class LanguageCrudServiceImpl implements LanguageCrudService{

    @Autowired
    LanguageRepository repository;

    private static final Logger log = LoggerFactory.getLogger(UserDeleteService.class);

    @Override
    public List<Language> getAll() {

        log.debug("Get All Languages");
        return this.repository.findAll();
    }

    @Override
    public Language getOne(long id) throws NotFoundException {

        log.debug("Get one Language");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Language create(final Language language) {

        log.debug("Create Language");
        return this.repository.save(language);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        log.debug("Delete Language");

        Language language = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(language);
    }

    @Override
    public boolean existsByLabel(Language language) {

        return this.repository.existsByLabel(language);
    }
}
