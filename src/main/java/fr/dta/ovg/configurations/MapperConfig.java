package fr.dta.ovg.configurations;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Initialize the mapper(s) used in this application.
 */
@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper buildMapper() {
        return new ModelMapper();
    }
}
