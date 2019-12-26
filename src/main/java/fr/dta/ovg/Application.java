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

import fr.dta.ovg.fixtures.FixtureService;


/** This is the main entry of OVG application.*/
@SpringBootApplication
public class Application implements CommandLineRunner {

    /** Local Logger declaration. */
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    /**Link to Fixture Service. */
    @Autowired(required = false)
    private FixtureService fixtures;

    /** Main. This is the main entry of OVG application.
     * @param args String array.*/
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /** Initialize DB with fixtures data.
     * Run method for fixtures initialization.
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[]).*/
    @Override
    public void run(final String... args) throws Exception {
        if (this.fixtures != null) {
            LOG.debug("Fixtures loading...");

            this.fixtures.load();

            LOG.debug("Fixtures loaded");
        }
    }
}
