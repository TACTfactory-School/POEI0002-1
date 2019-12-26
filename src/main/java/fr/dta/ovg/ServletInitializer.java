/* Servlet Initializer.
 * @author Colin Cerveaux @C-ambium
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/** SpringBoot Servlet Initializer Class.*/
public class ServletInitializer extends SpringBootServletInitializer {

    /** SpringBoot Application Builder Configuration.
     * @param application : @see SpringApplicationBuilder.
     * @return SpringApplicationBuilder.*/
    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
