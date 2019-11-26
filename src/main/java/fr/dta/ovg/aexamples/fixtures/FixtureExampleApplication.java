package com.ovg.app.aexamples.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ovg.app.aexamples.fixtures.services.FixtureService;

@SpringBootApplication
public class FixtureExampleApplication implements CommandLineRunner {

private static final Logger log = LoggerFactory.getLogger(FixtureExampleApplication.class);

    @Autowired(required = false)
    private FixtureService fixtures;

    public static void main(String[] args) {
        SpringApplication.run(FixtureExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.fixtures != null) {
            log.debug("Fixtures loading...");

            this.fixtures.load();

            log.debug("Fixtures loaded");
        }
    }
}
