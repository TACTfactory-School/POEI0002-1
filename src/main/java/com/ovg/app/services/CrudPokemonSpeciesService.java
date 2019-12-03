package com.ovg.app.services;

import java.util.List;

import com.ovg.app.entities.PokemonSpecies;
import com.ovg.app.repositories.PokemonSpeciesRepository;

public class CrudPokemonSpeciesService extends CrudService<PokemonSpecies, PokemonSpeciesRepository> {

    @Override
    public List<PokemonSpecies> findAll() {
        return super.findAll();
    }
}
