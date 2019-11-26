package com.ovg.app.aexamples.fixtures.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ovg.app.aexamples.fixtures.entities.Tasse;
import com.ovg.app.aexamples.fixtures.repositories.TasseRepository;

@Component
@Profile("!prod")
public class TasseFixtureService implements Fixture {

    @Autowired
    private TasseRepository repository;

    @Override
    public void load() {
        final List<Tasse> tasses = new ArrayList<>();
        final Random random = new Random();
        Tasse tasse;

        for (String label : new String[] {"Avenget", "Marvet", "Didi et dodo"}) {
            tasse = new Tasse();

            tasse.setLabel(label);
            tasse.setPrice(random.nextFloat());
            tasse.setStock(random.nextInt(100));

            tasses.add(tasse);
        }

        this.repository.saveAll(tasses);
    }
}
