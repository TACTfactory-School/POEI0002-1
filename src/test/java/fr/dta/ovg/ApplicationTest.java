package fr.dta.ovg;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/** Test class og the application main entry. @SpringBootTest */
@ActiveProfiles("test")
@ContextConfiguration
@RunWith(SpringRunner.class)
@TestPropertySource(locations = { "classpath:application.properties", "classpath:application-test.properties" })
 class ApplicationTest {

    /** Basic initial test. */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
