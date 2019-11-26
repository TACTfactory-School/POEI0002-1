package com.ovg.app.aexamples.fixtures.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class FixtureService implements Fixture {

    @Autowired
    private MugFixtureService mugFixture;

    @Autowired
    private TasseFixtureService tasseFixture;

    public void load() {
        this.mugFixture.load();
        this.tasseFixture.load();
    }
}
