/* This is the main entry of OVG application.
 * @author Colin Cerveaux @C-ambium
 * Void main run();
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.dta.ovg.services.FixtureService;

@SpringBootApplication
public class App implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    /**Link to Fixture Service*/
    @Autowired(required = false)
    private FixtureService fixtures;

    /** Main. This is the main entry of OVG application. */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /**Initialize DB with fixtures data.*/
    @Override
    public void run(String... args) throws Exception {
        if (this.fixtures != null) {
            log.debug("Fixtures loading...");

            this.fixtures.load();

            log.debug("Fixtures loaded");
        }
    }
}
