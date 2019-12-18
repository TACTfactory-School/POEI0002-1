/* Cors Configuration Class.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** CORS Configuration Class.*/
@Configuration
public class CorsConfig {

    /**
     * Cors Configurer.<br>
     * Desactivate Cors. Open MVC configuration.<br>
     * Allow all requests GET PUT POST PATCH DELETE OPTIONS.<br>
     * @return nothing (void).
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("GET", "PUT", "POST",
                        "PATCH", "DELETE", "OPTIONS");
            }
        };
    }
}
