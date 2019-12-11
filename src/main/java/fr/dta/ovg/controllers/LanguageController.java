package fr.dta.ovg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.ovg.entities.Language;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.LanguageCrudService;
import io.swagger.annotations.Api;


@RestController
@RequestMapping("api/v1/language")
@Api(value = "Language Management System", tags = "Language")
public class LanguageController {

    /** Link to Language CRUD Service. */
    @Autowired
    private LanguageCrudService service;

    /**
     * Get All function. <br>
     * GET - HTTP.
     * @return List of all Languages.
     */
    @GetMapping
    public List<Language> getAll() {
        return this.service.getAll();
    }

    /**
     * Get One by ID.<br>
     * GET - HTTP
     * @param id : number of the selected Language.
     * @return Entity Language.
     * @throws NotFoundException
     */
    @GetMapping("{id}")
    public Language getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * Create an Language.<br>
     * POST - HTTP.
     * @param language entity.
     * @return the created object Language.
     * @throws BadRequestException
     */
    @PostMapping
    public Language create(@Valid @RequestBody final Language language) throws BadRequestException {
        if (this.service.existsByLabel(language)) { // delete test
            throw new BadRequestException("uniq_name");
        }
        return this.service.create(language);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id : number of the selected Language.
     * @throws NotFoundException
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.service.delete(id);
    }
}
