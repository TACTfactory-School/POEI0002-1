/* Servlet Initializer.
 * @author Colin Cerveaux @C-ambium
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

}
