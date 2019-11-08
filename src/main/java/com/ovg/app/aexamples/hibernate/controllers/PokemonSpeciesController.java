package com.ovg.app.aexamples.hibernate.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ovg.app.aexamples.hibernate.entities.PokemonSpecies;
import com.ovg.app.aexamples.hibernate.repositories.PokemonSpeciesRepository;
import com.ovg.app.exceptions.BadRequestException;
import com.ovg.app.exceptions.NotFoundException;


@RestController
@RequestMapping("species")
public class PokemonSpeciesController {

    @Autowired
    private PokemonSpeciesRepository repository;

    @GetMapping
    public List<PokemonSpecies> getAll() {
        return this.repository.findAll();
    }

    @PostMapping
    public PokemonSpecies create(@Valid @RequestBody PokemonSpecies species) throws BadRequestException {
        if (this.repository.existsByName(species)) {
            throw new BadRequestException("uniq_name");
        }

        return this.repository.save(species);
    }

    @PutMapping("{id}")
    public PokemonSpecies update(@PathVariable Long id, @Valid @RequestBody PokemonSpecies species)
            throws BadRequestException, NotFoundException {
        if (this.repository.existsByNameIgnoreCaseAndIdNot(species.getName(), id)) {
            throw new BadRequestException("uniq_name");
        }

        final PokemonSpecies entity = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        // TODO: Use mapper.
//        ObjectMapper mapper = new ObjectMapper();
        // ---------
        entity.setName(species.getName());
        entity.setAttack(species.getAttack());
        entity.setAttackSpe(species.getAttackSpe());
        entity.setDefense(species.getDefense());
        entity.setDefenseSpe(species.getDefenseSpe());
        entity.setPv(species.getPv());

        return this.repository.save(entity);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

    @GetMapping("{id}")
    public PokemonSpecies getOne(@PathVariable Long id) throws NotFoundException {
        return this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }
}
