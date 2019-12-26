/* Language CRUD Service Implementation Class.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.ovg.entities.Language;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.LanguageRepository;
import fr.dta.ovg.services.LanguageCrudService;

/** Language CRUD service Implementation.*/
@Service
public class LanguageCrudServiceImpl implements LanguageCrudService {

    /** Link to entity repository. */
    @Autowired
    private LanguageRepository repository;

    /** Local Logger instance. */
    private static final Logger LOG = LoggerFactory.getLogger(UserDeleteService.class);

    /**{@inheritDoc}*/
    @Override
    public List<Language> getAll() {

        LOG.debug("Get All Languages");
        return this.repository.findAll();
    }

    /**{@inheritDoc}*/
    @Override
    public Language getOne(final long id) throws NotFoundException {

        LOG.debug("Get one Language");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    /**{@inheritDoc}*/
    @Override
    public Language create(final Language language) {

        LOG.debug("Create Language");
        return this.repository.save(language);
    }

    /**{@inheritDoc}*/
    @Override
    public void delete(final long id) throws NotFoundException {
        LOG.debug("Delete Language");

        Language language = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(language);
    }

    /**{@inheritDoc}*/
    @Override
    public boolean existsByLabel(final Language language) {

        return this.repository.existsByLabel(language);
    }
}
